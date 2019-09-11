package cp.practice.segmenttree.codeforces.round197;

import java.io.*;

public class D {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().trim().split(" ");
        int numQ = Integer.parseInt(line[1]);

        String[] line2 = br.readLine().trim().split(" ");
        long[] nums = new long[line2.length];
        for (int i = 0; i < line2.length; i++) {
            nums[i] = Long.parseLong(line2[i]);
        }

//        SegmentTree st = new SegmentTree(nums);

        for (int q = 0; q < numQ; q++) {
            String[] query = br.readLine().trim().split(" ");
            long idx = Long.parseLong(query[0]) - 1;
            long value = Long.parseLong(query[1]);

//            bw.write(st.update((int) idx, value) + "\n");
        }

        bw.flush();
    }
}

//public class SegmentTree {
//    long[] data;
//    int sz;
//
//    SegmentTree(long[] nums) {
//        data = new long[nums.length * 2];
//        sz = nums.length;
//
//        System.arraycopy(nums, 0, data, sz, sz);
//
//        for (int i = sz - 1; i > 0 ; i--) {
//            updateParentAt(i);
//        }
//    }
//
//    private double log2(int i) {
//        return Math.floor(Math.log(i) / Math.log(2));
//    }
//
//    long update(int idx, long value) {
//        idx += sz;
//        data[idx] = value;
//
//        while(idx > 1) {
//            idx /= 2;
//            updateParentAt(idx);
//        }
//
//        return data[1];
//    }
//
//    private void updateParentAt(int idx) {
//        //parity of log values on alternate levels will mismatch
//        if (log2(idx) % 2 != log2(sz) % 2)
//            data[idx] = data[2 * idx] | data[2 * idx + 1];
//        else
//            data[idx] = data[2 * idx] ^ data[2 * idx + 1];
//    }
//}

