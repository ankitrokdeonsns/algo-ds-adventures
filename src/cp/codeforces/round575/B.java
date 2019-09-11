package cp.codeforces.round575;

import java.io.*;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numQ = Integer.parseInt(br.readLine().trim());
        for (int q = 0; q < numQ; q++) {
            String[] line = br.readLine().trim().split(" ");
            int k = Integer.parseInt(line[1]);
            String[] line2 = br.readLine().trim().split(" ");
            int[] nums = new int[line2.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(line2[i]);
            }
            bw.write(solve(nums, k) + "\n");
        }

        bw.flush();
    }

    private static String solve(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 1) {
                count++;
            }
        }
        if(count >= k && (count - k) % 2 == 0) {
            StringBuilder sb = new StringBuilder("YES\n");
            int c = 0;
            for (int i = 0; (c < k - 1) && i < nums.length; i++) {
                if(nums[i] % 2 == 1) {
                    sb.append((i + 1) + " ");
                    c++;
                }
            }
            sb.append(nums.length);
            return sb.toString();

        }
        return "NO";
    }
}

