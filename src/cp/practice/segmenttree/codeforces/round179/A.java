package cp.practice.segmenttree.codeforces.round179;

import java.io.*;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().trim().split(" ");
        int numOps = Integer.parseInt(line[1]);
        Op[] ops = new Op[numOps];
        int numQ = Integer.parseInt(line[2]);
        Range[] queries = new Range[numQ];
        String[] line2 = br.readLine().trim().split(" ");
        int[] nums = new int[line2.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(line2[i]);
        }
        for (int i = 0; i < ops.length; i++) {
            String[] op = br.readLine().trim().split(" ");
            int start = Integer.parseInt(op[0]);
            int end = Integer.parseInt(op[1]);
            int incr = Integer.parseInt(op[2]);
            ops[i] = new Op(start - 1, end - 1, incr);
        }
        for (int i = 0; i < queries.length; i++) {
            String[] query = br.readLine().trim().split(" ");
            int start = Integer.parseInt(query[0]);
            int end = Integer.parseInt(query[1]);
            queries[i] = new Range(start, end);
        }

        bw.write(solve(nums, ops, queries) + "\n");

        bw.flush();
    }

    private static String solve(int[] nums, Op[] ops, Range[] queries) {
        OpTree opCount = new OpTree(nums.length);
        for (int i = 0; i < queries.length; i++) {
            opCount.update(queries[i]);
        }
        SegmentTree tree = new SegmentTree(nums.length);
        for (int i = 0; i < ops.length; i++) {
            System.out.println(i + 1 + " " + opCount.getOpCount(i + 1));
//            int delta = opCount.getOpCount(i + 1) * ops[i].incr;
//            tree.update(ops[i].start, ops[i].end, delta);
        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < nums.length; i++) {
//            sb.append(tree.get(i) + nums[i] + " ");
//        }
//        return sb.toString().trim();
        return null;
    }
}

class SegmentTree {
    int sz;
    int[] data;

    SegmentTree(int sz) {
        this.sz = sz;
        data = new int[sz * 4];

    }

    public void update(int start, int end, int delta) {
        update(start, end, delta, 0, sz - 1, 0);
    }

    private void update(int qStart, int qEnd, int delta, int segStart, int segEnd, int segRoot) {
        if(segStart > segEnd) return;

        if(qStart > segEnd || qEnd < segStart) return;

        if(qStart <= segStart && qEnd >= segEnd) {
            data[segRoot] += delta;
            return;
        }
        if(segStart != segEnd) {
            int mid = segStart + (segEnd - segStart) / 2;
            update(qStart, qEnd, delta, segStart, mid, 2 * segRoot + 1);
            update(qStart, qEnd, delta, mid + 1, segEnd, 2 * segRoot + 2);
        }

    }

    public int get(int idx) {
        return get(idx, 0, sz - 1, 0);

    }

    private int get(int idx, int segStart, int segEnd, int root) {
        if(segStart > segEnd) return 0;

        if(idx < segStart || idx > segEnd) return 0;

        int ans = 0;

        ans += data[root];

        if(segStart != segEnd) {
            int mid = segStart + (segEnd - segStart) / 2;
            ans += get(idx, segStart, mid, 2 * root + 1);
            ans += get(idx, mid + 1, segEnd, 2 * root + 2);
        }
        return ans;
    }
}

class OpTree {
    int sz;
    int[] count;

    OpTree(int sz) {
        this.sz = sz;
        count = new int[sz * 4 + 1];
    }

    public void update(Range rng) {
        update(rng.start, rng.end, 0, sz, 0);
    }

    private void update(int qStart, int qEnd, int segStart, int segEnd, int root) {
        if(segStart > segEnd) return;

        if(qStart > segEnd || qEnd < segStart) return;

        if(segStart >= qStart && segEnd <= qEnd) {
            count[root] += 1;
        }

        if(segStart != segEnd) {
            int mid = segStart + (segEnd - segStart) / 2;
            update(qStart, qEnd, segStart, mid, 2 * root + 1);
            update(qStart, qEnd, mid + 1, segEnd, 2 * root + 2);
        }

    }

    int getOpCount(int op) {
        return getOpCount(op, 0, sz, 0);
    }

    private int getOpCount(int op, int segStart, int segEnd, int root) {
        if(segStart > segEnd) return 0;

        if(op < segStart || op > segEnd) return 0;

        int ans = 0;

        ans += count[root];

        if(segStart != segEnd) {
            int mid = segStart + (segEnd - segStart) / 2;
            ans += getOpCount(op, segStart, mid, 2 * root + 1);
            ans += getOpCount(op, mid + 1, segEnd, 2 * root + 2);
        }
        return ans;
    }
}

class Op {

    int start;
    int end;
    int incr;

    public Op(int start, int end, int incr) {
        this.start = start;
        this.end = end;
        this.incr = incr;
    }
}

class Range {
    int start;
    int end;

    Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

}
