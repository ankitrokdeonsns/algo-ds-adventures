package cp.codeforces.round573;

import java.io.*;

//change class name to Solution
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().trim().split(" ");
        bw.write(solve(line) + "\n");

        bw.flush();
    }

    private static int solve(String[] line) {
        int[] m = new int[9];
        int[] p = new int[9];
        int[] s = new int[9];
        for (int i = 0; i < line.length; i++) {
            if(line[i].charAt(1) == 'm') {
                m[line[i].charAt(0) - '1']++;
            } else if(line[i].charAt(1) == 'p') {
                p[line[i].charAt(0) - '1']++;

            } else {
                s[line[i].charAt(0) - '1']++;
            }
        }
        int maxRepeatedInM = 0;
        for (int i = 0; i < m.length; i++) {
            maxRepeatedInM = Math.max(maxRepeatedInM, m[i]);
        }
        int maxRepeatedInP = 0;
        for (int i = 0; i < p.length; i++) {
            maxRepeatedInP = Math.max(maxRepeatedInP, p[i]);
        }
        int maxRepeatedInS = 0;
        for (int i = 0; i < s.length; i++) {
            maxRepeatedInS = Math.max(maxRepeatedInS, s[i]);
        }
        int maxConsecutiveInM = 0;
        for (int i = 0; i < m.length - 2; i++) {
            int consecutive = 0;
            if(m[i] > 0) {
                consecutive++;
            }
            if(m[i + 1] > 0) {
                consecutive++;
            }
            if(m[i + 2] > 0) {
                consecutive++;
            }
            maxConsecutiveInM = Math.max(maxConsecutiveInM, consecutive);
        }
        int maxConsecutiveInP = 0;
        for (int i = 0; i < p.length - 2; i++) {
            int consecutive = 0;
            if(p[i] > 0) {
                consecutive++;
            }
            if(p[i + 1] > 0) {
                consecutive++;
            }
            if(p[i + 2] > 0) {
                consecutive++;
            }
            maxConsecutiveInP = Math.max(maxConsecutiveInP, consecutive);
        }
        int maxConsecutiveInS = 0;
        for (int i = 0; i < s.length - 2; i++) {
            int consecutive = 0;
            if(s[i] > 0) {
                consecutive++;
            }
            if(s[i + 1] > 0) {
                consecutive++;
            }
            if(s[i + 2] > 0) {
                consecutive++;
            }
            maxConsecutiveInM = Math.max(maxConsecutiveInM, consecutive);
        }
        int tilesNeededForMKoutsu = 3 - maxRepeatedInM;
        int tilesNeededForPKoutsu = 3 - maxRepeatedInP;
        int tilesNeededForSKoutsu = 3 - maxRepeatedInS;
        int tilesNeededForMShuntsu = 3 - maxConsecutiveInM;
        int tilesNeededForPShuntsu = 3 - maxConsecutiveInP;
        int tilesNeededForSShuntsu = 3 - maxConsecutiveInS;
        int ans = tilesNeededForMKoutsu;
        ans = Math.min(ans, tilesNeededForPKoutsu);
        ans = Math.min(ans, tilesNeededForSKoutsu);
        ans = Math.min(ans, tilesNeededForMShuntsu);
        ans = Math.min(ans, tilesNeededForPShuntsu);
        ans = Math.min(ans, tilesNeededForSShuntsu);
        return ans;

    }
}

