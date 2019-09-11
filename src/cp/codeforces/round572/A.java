package cp.codeforces.round572;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        String s = br.readLine().trim();
        bw.write(solve(s) + "\n");
        bw.flush();

    }

    private static String solve(String s) {
        Ans[][] mem = new Ans[s.length()][s.length()];
        cutMinimal(s, 0, s.length() - 1, mem);
        Ans ans = mem[0][s.length() - 1];
        String val = String.valueOf(ans.cuts + 1) + "\n";
        for(String subString: ans.subStrings) {
            val += subString + " ";
        }
        return val.trim();
    }

    private static Ans cutMinimal(String s, int low, int high, Ans[][] mem) {
        if(mem[low][high] != null)
            return mem[low][high];
        if(isGood(s, low, high)) {
            List<String> candidates = new ArrayList<>();
            candidates.add(s.substring(low, high + 1));
            Ans ans = new Ans(0, candidates);
            mem[low][high] = ans;
            return mem[low][high];
        }
        Ans ans = new Ans(Integer.MAX_VALUE, null);
        for (int i = low; i < high; i++) {
            Ans leftAns = cutMinimal(s, low, i, mem);
            Ans rightAns = cutMinimal(s, i + 1, high, mem);
            if(leftAns.cuts + rightAns.cuts < ans.cuts) {
                leftAns.subStrings.addAll(rightAns.subStrings);
                leftAns.update(leftAns.cuts + rightAns.cuts + 1, leftAns.subStrings);
                ans = leftAns;
            }
        }
        mem[low][high] = ans;
        return mem[low][high];
    }

    private static boolean isGood(String s, int low, int high) {
        int count0 = 0;
        int count1 = 0;
        for (int i = low; i <= high; i++) {
            if(s.charAt(i) == '0') count0++;
            else count1++;
        }
        return count0 != count1;
    }

    static class Ans {
        int cuts;
        List<String> subStrings;
        Ans(int cuts, List<String> candidates) {
            this.cuts = cuts;
            subStrings = candidates;
        }

        void update(int cuts, List<String> candidates) {
            this.cuts = cuts;
            subStrings = candidates;
        }
    }
}

