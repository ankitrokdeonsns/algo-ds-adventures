package cp.codeforces.round576;

import java.io.*;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().trim().split(" ");
        int x = Integer.parseInt(line[1]);
        int y = Integer.parseInt(line[2]);

        String[] line2 = br.readLine().trim().split(" ");
        int[] rainfall = new int[line2.length];
        for (int i = 0; i < rainfall.length; i++) {
            rainfall[i] = Integer.parseInt(line2[i]);
        }

        bw.write(solve(rainfall, x, y) + "\n");

        bw.flush();
    }

    private static int solve(int[] rainfall, int x, int y) {
        for (int day = 0; day < rainfall.length; day++) {
            if(isNotSoRainy(day, rainfall, x, y))
                return day + 1;
        }
        return rainfall.length;
    }

    private static boolean isNotSoRainy(int day, int[] rainfall, int x, int y) {
        int beforeCount = 1;
        while(beforeCount <= x && day - beforeCount >= 0) {
            if(rainfall[day - beforeCount] < rainfall[day])
                return false;
            beforeCount++;
        }
        int afterCount = 1;
        while(afterCount <= y && day + afterCount < rainfall.length) {
            if(rainfall[day + afterCount] < rainfall[day])
                return false;
            afterCount++;
        }
        return true;
    }
}

