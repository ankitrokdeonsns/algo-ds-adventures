package cp.codeforces.round572;

import java.io.*;
import java.util.Arrays;

public class B {
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
        Arrays.sort(nums);
        if(nums[nums.length - 1] >= nums[nums.length - 2] + nums[0]) {
            if (nums[nums.length - 1] >= nums[nums.length - 2] + nums[nums.length - 3])
                return "NO";
            else {
                int t = nums[nums.length - 1];
                nums[nums.length - 1] = nums[nums.length - 2];
                nums[nums.length - 2] = t;
            }
        }
        StringBuilder ans = new StringBuilder("YES\n");
        for (int i = 0; i < nums.length; i++) {
            ans.append(nums[i] + " ");
        }
        return ans.toString().trim();
    }
}
