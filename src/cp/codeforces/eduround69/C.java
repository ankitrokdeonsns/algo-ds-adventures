package cp.codeforces.eduround69;

import java.io.*;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().trim().split(" ");
        int k = Integer.parseInt(line[1]);
        String[] line2 = br.readLine().trim().split(" ");
        int[] nums = new int[line2.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(line2[i]);
        }

        bw.write(solve(nums, k) + "\n");

        bw.flush();
    }

    private static int solve(int[] nums, int k) {
        if(k == 1) return nums[nums.length - 1] - nums[0];
        int high = nums.length - k;
        while(high > 0 && nums[high] == nums[nums.length - k + 1]) {
            high--;
        }
        return nums[high] - nums[0];
    }
}

