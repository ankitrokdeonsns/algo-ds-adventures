package cp.codechef.lunchtime.june2019;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class SillyPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numT = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < numT; t++) {
            int sz = Integer.parseInt(br.readLine().trim());
            Integer[] a = new Integer[sz];
            Integer[] b = new Integer[sz];
            String[] l1 = br.readLine().trim().split(" ");
            String[] l2 = br.readLine().trim().split(" ");
            for (int i = 0; i < sz; i++) {
                a[i] = Integer.parseInt(l1[i]);
                b[i] = Integer.parseInt(l2[i]);
            }
            bw.write(solve(a, b) + "\n");
        }
        bw.flush();

    }

    private static long solve(Integer[] a, Integer[] b) {
        if(a.length == 1) return (a[0] + b[0]) / 2;
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        long ans = 0;
        for (int i = 2; i < a.length; i++) {
            ans += (a[i] + b[i]) / 2;
        }
        ans += (a[0] + b[1]) / 2;
        ans += (a[1] + b[0]) / 2;
        return ans;

    }
}
