package cp.codeforces.eduround70;

import java.io.*;

public class D {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numT = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < numT; t++) {
            int n = Integer.parseInt(br.readLine().trim());
            bw.write(solve(n) + "\n");
        }

        bw.flush();
    }

    private static String solve(int n) {
        if(n == 1) return "1337";
        int limit = (int) Math.ceil(Math.sqrt(n)) + 1;

        for (int i = 1; i <= limit; i++) {
            if(n % i == 0) {
                long x = (8 * (long) n) / (long) i + 1;
                if (isPerfectSquare(x)) {
                    long numThrees = ((long) Math.floor(Math.sqrt(x)) + 1) / 2;
                    long size = i + numThrees + 1;
                    if (size <= 100000) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(new String(new char[i]).replace('\0', '1'));
                        sb.append(new String(new char[(int)numThrees]).replace('\0', '3'));
                        sb.append('7');
                        return sb.toString();
                    }
                }
                x = 8 * (long) i + 1;
                if (isPerfectSquare(x)) {
                    long numThrees = ((long) Math.floor(Math.sqrt(x)) + 1) / 2;
                    long size = i + numThrees + 1;
                    if (size <= 100000) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(new String(new char[n / i]).replace('\0', '1'));
                        sb.append(new String(new char[(int)numThrees]).replace('\0', '3'));
                        sb.append('7');
                        return sb.toString();
                    }
                }
            }
        }
        return null;
    }



    private static boolean isPerfectSquare(long x) {
        double sqrt = Math.sqrt(x);
        double floor = Math.floor(sqrt);
        return sqrt - floor <= 0.000001;
    }
}

