package cp.codeforces.round570;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class CandyBoxEasy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numQ = Integer.parseInt(br.readLine().trim());
        for (int q = 0; q < numQ; q++) {
            br.readLine();
            String[] line = br.readLine().trim().split(" ");
            int[] candies = new int[line.length];
            for (int i = 0; i < line.length; i++) {
                candies[i] = Integer.parseInt(line[i]);
            }
            bw.write(solve(candies) + "\n");
        }
        bw.flush();

    }

    private static int solve(int[] candies) {
        Integer[] mem = new Integer[candies.length + 1];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = 0;
        }
        for (int i = 0; i < candies.length; i++) {
            mem[candies[i]] += 1;
        }
        Arrays.sort(mem, Collections.reverseOrder());

        boolean[] taken = new boolean[candies.length + 1];
        int ans = 0;
        for (int i = 0; i < mem.length; i++) {
            int count = mem[i];
            while(count > 0 && taken[count]) {
                count--;
            }
            ans += count;
            taken[count] = true;
        }
        return ans;
    }
}
