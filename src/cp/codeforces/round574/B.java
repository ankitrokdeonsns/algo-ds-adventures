package cp.codeforces.round574;

import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().trim().split(" ");
        long n = Long.parseLong(line[0]);
        long k = Long.parseLong(line[1]);
        bw.write(solve(n, k) + "\n");

        bw.flush();

    }

    private static long solve(long n, long k) {
        return n - ((long) (Math.sqrt(9 + 8 * (k + n)) - 3)) / 2;
    }
}

