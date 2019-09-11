package cp.codeforces.round570;

import java.io.*;

public class NearestInterestingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine().trim());
        bw.write(solve(a) + "\n");
        bw.flush();
    }

    private static int solve(int a) {
        int n = a;
        while(sumDig(n) % 4 != 0) {
            n++;
        }
        return n;
    }

    private static int sumDig(int n) {
        int sum = 0;
        while(n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
