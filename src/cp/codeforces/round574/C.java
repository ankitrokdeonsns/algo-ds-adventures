package cp.codeforces.round574;

import java.io.*;
import java.util.Arrays;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        String[] line1 = br.readLine().trim().split(" ");
        String[] line2 = br.readLine().trim().split(" ");
        int[] h1 = new int[line1.length];
        int[] h2 = new int[line2.length];
        for (int i = 0; i < line1.length; i++) {
            h1[i] = Integer.parseInt(line1[i]);
            h2[i] = Integer.parseInt(line2[i]);
        }

        bw.write(solve(h1, h2) + "\n");

        bw.flush();

    }

    private static long solve(int[] h1, int[] h2) {
        long[][][] mem = new long[h1.length][2][3];
        for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[i].length; j++) {
                Arrays.fill(mem[i][j], -1);
            }
        }
        long a = helper(h1.length - 1, 0, 0, h1, h2, mem);
        long b = helper(h1.length - 1, 0, 1, h1, h2, mem);
        return Math.max(a, b);
    }

    private static long helper(int i, int choseInPrev, int turn, int[] h1, int[] h2, long[][][] mem) {
        if(i < 0) {
            return 0;
        }
        if(turn != -1 && mem[i][choseInPrev][turn] != -1)
            return mem[i][choseInPrev][turn];

        if(choseInPrev == 1) {
            if(turn == 0) {
                mem[i][choseInPrev][turn] = Math.max(h1[i] + helper(i - 1, 1, 1, h1, h2, mem)
                                , helper(i - 1, 0, 2, h1, h2, mem));
            } else {
                mem[i][choseInPrev][turn] = Math.max(h2[i] + helper(i - 1, 1, 0, h1, h2, mem)
                        , helper(i - 1, 0, 2, h1, h2, mem));

            }
        } else {
            long a = h1[i] + helper(i - 1, 1, 1, h1, h2, mem);
            long b = h2[i] + helper(i - 1, 1, 0, h1, h2, mem);
            long c = helper(i - 1, 0, 2, h1, h2, mem);
            mem[i][choseInPrev][turn] = Math.max(a, Math.max(b, c));
        }

        return mem[i][choseInPrev][turn];

    }
}

