package cp.codeforces.round574;

import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().trim().split(" ");
        int[] types = new int[Integer.parseInt(line[0])];
        int k = Integer.parseInt(line[1]);

        for (int i = 0; i < types.length; i++) {
            types[i] = Integer.parseInt(br.readLine().trim());
        }
        bw.write(solve(types, k) + "\n");

        bw.flush();

    }

    private static int solve(int[] types, int k) {
        int[] count = new int[k + 1];
        for (int i = 0; i < types.length; i++) {
            count[types[i]]++;
        }
        int ans = 0;
        int misMatchCount = 0;
        for (int i = 0; i < count.length; i++) {
            ans += (count[i] / 2) * 2;
            misMatchCount += (count[i] % 2);
        }

        return ans + (misMatchCount / 2) + (misMatchCount % 2);
    }
}
