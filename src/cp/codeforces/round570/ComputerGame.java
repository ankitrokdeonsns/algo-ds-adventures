package cp.codeforces.round570;

import java.io.*;

public class ComputerGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numQ = Integer.parseInt(br.readLine().trim());
        for (int q = 0; q < numQ; q++) {
            String[] line = br.readLine().trim().split(" ");
            long k = Long.parseLong(line[0]);
            long n = Long.parseLong(line[1]);
            long a = Long.parseLong(line[2]);
            long b = Long.parseLong(line[3]);
            bw.write(solve(k, n, a, b) + "\n");
        }
        bw.flush();

    }

    private static long solve(long k, long n, long a, long b) {
        if(k - b * n <= 0) return -1;
        long maxTurns = (k - b * n) / (a - b);
        if(k - maxTurns * a > 0) return Math.min(maxTurns, n);
        return Math.min(maxTurns - 1, n);
    }
}
