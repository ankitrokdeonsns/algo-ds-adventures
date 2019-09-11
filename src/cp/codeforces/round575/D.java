package cp.codeforces.round575;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class D {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numQ = Integer.parseInt(br.readLine().trim());
        for (int q = 0; q < numQ; q++) {
            String[] line = br.readLine().trim().split(" ");
            int k = Integer.parseInt(line[1]);
            String str = br.readLine().trim();
            bw.write(solve(str, k) + "\n");
        }

        bw.flush();
    }

    private static int solve(String str, int k) {
        String[] candidates = generateCandidates(k);
        Set<String> looked = new HashSet<>();

        int minUpdates = k;
        for (int i = 0; i <= str.length() - k; i++) {
            String substring = str.substring(i, i + k);
            if(!looked.contains(substring)) {
                minUpdates = Math.min(minUpdates, getMinDistance(substring, candidates));
                looked.add(substring);
            }
        }

        return minUpdates;
        
    }

    private static String[] generateCandidates(int k) {
        StringBuilder sb0 = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int len = 0;
        while(len + 3 <= k) {
            sb0.append("RGB");
            sb1.append("GBR");
            sb2.append("BRG");
            len += 3;
        }
        int needed = k - len;
        if(needed == 1) {
            sb0.append("R");
            sb1.append("G");
            sb2.append("B");
        }
        if(needed == 2) {
            sb0.append("RG");
            sb1.append("GB");
            sb2.append("BR");
        }
        String[] candidates = new String[3];
        candidates[0] = sb0.toString();
        candidates[1] = sb1.toString();
        candidates[2] = sb2.toString();
        return candidates;
    }

    private static int getMinDistance(String substring, String[] candidates) {
        int[] distance = new int[candidates.length];
        for (int i = 0; i < substring.length(); i++) {
            if(substring.charAt(i) != candidates[0].charAt(i))
                distance[0]++;
            if(substring.charAt(i) != candidates[1].charAt(i))
                distance[1]++;
            if(substring.charAt(i) != candidates[2].charAt(i))
                distance[2]++;
        }
        int minDistance = distance[0];
        minDistance = Math.min(minDistance, distance[1]);
        minDistance = Math.min(minDistance, distance[2]);
        return minDistance;
    }
}

