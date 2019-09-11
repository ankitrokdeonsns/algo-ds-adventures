package cp.codeforces.eduround69;

import java.io.*;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numQ = Integer.parseInt(br.readLine().trim());
        for (int q = 0; q < numQ; q++) {
            br.readLine();
            String[] line = br.readLine().trim().split(" ");
            int[] ladders = new int[line.length];
            for (int i = 0; i < ladders.length; i++) {
                ladders[i] = Integer.parseInt(line[i]);
            }
            bw.write(solve(ladders) + "\n");
        }

        bw.flush();
    }

    private static int solve(int[] ladders) {
        if(ladders.length <= 2) return 0;
        int max = Math.max(ladders[0], ladders[1]);
        int max2 = Math.min(ladders[0], ladders[1]);
        for (int i = 2; i < ladders.length; i++) {
            if(ladders[i] > max) {
                max2 = max;
                max = ladders[i];
            } else if(ladders[i] > max2) {
                max2 = ladders[i];
            }

        }
        return Math.min(max2 - 1, ladders.length - 2);

    }
}

