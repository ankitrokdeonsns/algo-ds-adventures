package cp.codeforces.round573;

import java.io.*;

//change class name to Solution
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().trim().split(" ");
        long pageSize = Long.parseLong(line[2]);
        String[] line2 = br.readLine().trim().split(" ");
        long[] nums = new long[line2.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Long.parseLong(line2[i]);
        }
        bw.write(solve(nums, pageSize) + "\n");
        bw.flush();
    }

    private static int solve(long[] nums, long pageSize) {
        if(nums.length == 0) return 0;
        int ans = 0;
        int current = 0;
        long currentPage = (nums[current] - 1) / pageSize;
        int offset = 0;
        while(current < nums.length) {
            int j = 1;
            int removed = 1;
            while(current + j < nums.length && (nums[current + j] - 1 - offset)/ pageSize == currentPage) {
                removed++;
                j++;
            }
            ans++;
            current += j;
            if(current >= nums.length)
                break;
            offset += removed;
            currentPage = (nums[current] - 1 - offset) / pageSize;
        }
        return ans;
    }
}


