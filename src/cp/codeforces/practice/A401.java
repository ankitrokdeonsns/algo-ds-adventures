package cp.codeforces.practice;

import java.io.*;

public class A401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().trim().split(" ");
        int x = Integer.parseInt(line[1]);
        String[] line2 = br.readLine().trim().split(" ");
        int[] nums = new int[line2.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(line2[i]);
        }
        bw.write(solve(nums, x) + "\n");
        bw.flush();

    }

    private static int solve(int[] nums, int x) {
        int[] countPos = new int[x + 1];
        int[] countNeg = new int[x + 1];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                countPos[nums[i]]++;
            else
                countNeg[Math.abs(nums[i])]++;
        }
        int ans = 0;
        for (int i = 0; i < countNeg.length; i++) {
            ans += Math.abs(countNeg[i] - countPos[i]);
        }
        return ans;
    }
}
