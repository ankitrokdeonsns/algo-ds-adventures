package cp.codechef.lunchtime.june2019;

import java.io.*;

public class PajaPong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numT = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < numT; t++) {
            String[] line = br.readLine().trim().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int k = Integer.parseInt(line[2]);
            bw.write(solve(x, y, k) + "\n");
        }
        bw.flush();

    }

    private static String solve(int x, int y, int k) {
        if(((x + y) / k) % 2 == 1) return "Paja";
        return "Chef";
    }
}
