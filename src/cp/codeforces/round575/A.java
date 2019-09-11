package cp.codeforces.round575;

import java.io.*;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numQ = Integer.parseInt(br.readLine().trim());
        for (int q = 0; q < numQ; q++) {
            String[] line = br.readLine().trim().split(" ");
            long[] piles = new long[line.length];
            for (int i = 0; i < piles.length; i++) {
                piles[i] = Long.parseLong(line[i]);
            }
            bw.write(solve(piles) + "\n");
        }

        bw.flush();
    }

    private static long solve(long[] piles) {
        long sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
        }
        return sum / 2;
    }
}

