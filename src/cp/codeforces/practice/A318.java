package cp.codeforces.practice;

import java.io.*;

public class A318 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        String[] line = br.readLine().trim().split(" ");
        int[] nums = new int[line.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }
        bw.write(solve(nums) + "\n");
        bw.flush();
    }

    private static String solve(int[] nums) {
        int[] residual = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            residual[i] = residual(nums[i]);

        }
        for (int i = 0; i < residual.length; i++) {
            if(residual[i] != residual[0])
                return "No";
        }
        return "Yes";
    }

    private static int residual(int n) {
        while(n % 3 == 0) {
            n /= 3;
        }
        while(n % 2 == 0) {
            n /= 2;
        }
        return n;
    }

}

