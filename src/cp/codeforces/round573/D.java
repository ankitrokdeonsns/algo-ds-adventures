package cp.codeforces.round573;

import java.io.*;
import java.util.Arrays;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        String[] line = br.readLine().trim().split(" ");
        int[] nums = new int[line.length];
        bw.write(solve(nums));
        bw.flush();
    }

    private static String solve(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] - i;
        }
        if(sum % 2 == 0)
            return "cslnb\n";
        return "sjfnb\n";
    }
}
