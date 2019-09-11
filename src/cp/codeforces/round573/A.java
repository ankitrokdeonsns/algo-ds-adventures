package cp.codeforces.round573;

import java.io.*;
//change class name to Solution
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int hp = Integer.parseInt(br.readLine().trim());
        bw.write(solve(hp) + "\n");

        bw.flush();
    }

    private static String solve(int hp) {
        int current = hp % 4;
        int best = current;
        int add = 0;
        if(isBetter((current + 1) % 4, best)) {
            best = (current + 1) % 4;
            add = 1;
        }

        if(isBetter((current + 2) % 4, best)) {
            best = (current + 2) % 4;
            add = 2;
        }

        return add + " " + getCategory(best);

    }

    private static String getCategory(int category) {
        if(category == 1) return "A";
        if(category == 3) return "B";
        if(category == 2) return "C";
        return "D";
    }

    private static boolean isBetter(int category, int best) {
        if(category == 1) return true;
        if(category == 2) return best == 0;
        if(category == 3) return best == 2 || best == 0;
        return false;
    }
}
