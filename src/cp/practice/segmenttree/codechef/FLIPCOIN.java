package cp.practice.segmenttree.codechef;

import java.io.*;

public class FLIPCOIN {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().trim().split(" ");
        int sz = Integer.parseInt(line[0]);
        SegmentTree st = new SegmentTree(sz);
        int numQ = Integer.parseInt(line[1]);
        for (int q = 0; q < numQ; q++) {
            String[] query = br.readLine().trim().split(" ");
            int type = Integer.parseInt(query[0]);
            int start = Integer.parseInt(query[1]);
            int end = Integer.parseInt(query[2]);
            if(type == 0) {
                st.flip(start, end);
            } else {
                bw.write(st.getHeads(start, end) + "\n");
            }
        }

        bw.flush();
    }

}

class SegmentTree {
    boolean[] lazy;
    int[] headCount;
    int sz;

    SegmentTree(int sz) {
        this.sz = sz;
        lazy = new boolean[4 * sz];
        headCount = new int[lazy.length];
    }

    void flip(int start, int end) {
        flipLazy(start, end, 0, sz - 1, 0);
    }

    private void flipLazy(int qStart, int qEnd, int segStart, int segEnd, int segRoot) {
        if(segStart > segEnd) return;

        if(lazy[segRoot]) {
            headCount[segRoot] = segEnd - segStart  + 1 - headCount[segRoot];
            if(segStart != segEnd) {
                lazy[2 * segRoot + 1] = lazy[segRoot];
                lazy[2 * segRoot + 2] = lazy[segRoot];
            }
            lazy[segRoot] = false;
        }

        if(qStart > segEnd || qEnd < segStart) { // no overlap
            return;
        }

        if(segStart >= qStart && segEnd <= qEnd) { // total overlap
            headCount[segRoot] = segEnd - segStart  + 1 - headCount[segRoot];
            if(segStart != segEnd) {
                lazy[2 * segRoot + 1] = !lazy[2 * segRoot + 1];
                lazy[2 * segRoot + 2] = !lazy[2 * segRoot + 2];
            }
            return;
        }

        //partial overlap
        int mid = segStart + (segEnd - segStart) / 2;
        flipLazy(qStart, qEnd, segStart, mid, 2 * segRoot + 1);
        flipLazy(qStart, qEnd, mid + 1, segEnd, 2 * segRoot + 2);

        headCount[segRoot] = headCount[2 * segRoot + 1] + headCount[2 * segRoot + 2];

    }

    public int getHeads(int qStart, int qEnd) {
        return getHeadsLazy(qStart, qEnd, 0, sz - 1, 0);
    }

    private int getHeadsLazy(int qStart, int qEnd, int segStart, int segEnd, int segRoot) {
        if(segStart > segEnd) return 0;

        if(lazy[segRoot]) {
            headCount[segRoot] = segEnd - segStart  + 1 - headCount[segRoot];
            if(segStart != segEnd) {
                lazy[2 * segRoot + 1] = lazy[segRoot];
                lazy[2 * segRoot + 2] = lazy[segRoot];
            }
            lazy[segRoot] = false;
        }

        if(qStart > segEnd || qEnd < segStart) { // no overlap
            return 0;
        }

        if(segStart >= qStart && segEnd <= qEnd) { // total overlap
            return headCount[segRoot];
        }

        //partial overlap
        int mid = segStart + (segEnd - segStart) / 2;
        return getHeadsLazy(qStart, qEnd, segStart, mid, 2 * segRoot + 1)
                + getHeadsLazy(qStart, qEnd, mid + 1, segEnd, 2 * segRoot + 2);
    }
}

