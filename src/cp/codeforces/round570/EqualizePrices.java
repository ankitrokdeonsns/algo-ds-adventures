package cp.codeforces.round570;

import java.io.*;
import java.util.Arrays;

public class EqualizePrices {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numQ = Integer.parseInt(br.readLine().trim());
        for (int q = 0; q < numQ; q++) {
            String[] line = br.readLine().trim().split(" ");
            int sz = Integer.parseInt(line[0]);
            long k = Long.parseLong(line[1]);
            long[] nums = new long[sz];
            String[] line2 = br.readLine().trim().split(" ");
            for (int i = 0; i < line2.length; i++) {
                nums[i] = Long.parseLong(line2[i]);
            }
            bw.write(solve(nums, k) + "\n");
        }

        bw.flush();
    }

    private static long solve(long[] nums, long k) {
        long min = Arrays.stream(nums).min().getAsLong();
        long max = Arrays.stream(nums).max().getAsLong();
        if(max - min > 2 * k) return -1;
        return min + k;
    }
}
