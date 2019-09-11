package cp.codeforces.eduround69;

import java.io.*;

public class D {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().trim().split(" ");
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        String[] line2 = br.readLine().trim().split(" ");
        int[] nums = new int[line2.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(line2[i]);
        }

        bw.write(solve(nums, m, k) + "\n");

        bw.flush();
    }

    static int solve(int[] nums, int m, int k) {
        int[] mem = new int[nums.length];
        int low = 0;
        int cost = (int) (nums[low] - k * Math.ceil(1.0 / m));
        while(low < nums.length && cost < 0) {
            mem[low] = cost;
            low++;
            cost = (int) (nums[low] - k * Math.ceil(1.0 / m));
        }
        int high = low + 1;
        while(high < nums.length) {
            mem[high] = (int) (mem[low] + nums[high] + k * Math.ceil((high - low) * 1.0 / m) - k * Math.ceil((high - low + 1) * 1.0 / m));
            if(mem[high] < 0) {
                low = high + 1;
                high = low;
            } else {
                high++;
            }
        }
        int maxCost = mem[0];
        for (int i = 1; i < mem.length; i++) {
            maxCost = Math.max(maxCost, mem[i]);
        }
        if(maxCost < 0)
            return 0;
        return maxCost;
    }
}

