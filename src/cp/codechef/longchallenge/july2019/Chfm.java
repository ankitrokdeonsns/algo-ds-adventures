package cp.codechef.longchallenge.july2019;

import java.io.*;

public class Chfm {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numT = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < numT; t++) {
            br.readLine();
            String[] line = br.readLine().trim().split(" ");
            int[] coins = new int[line.length];
            for (int i = 0; i < coins.length; i++) {
                coins[i] = Integer.parseInt(line[i]);
            }
            bw.write(solve(coins) + "\n");
        }
        bw.flush();
    }

    private static String solve(int[] coins) {
        long sum = 0;
        for (int i = 0; i < coins.length; i++) {
            sum += coins[i];
        }
        double mean = sum * 1.0 / coins.length;

        for (int i = 0; i < coins.length; i++) {
            if(coins[i] == mean)
                return String.valueOf(i + 1);
        }

        return "Impossible";
    }
}
