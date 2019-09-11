package cp.codeforces.round575;

import java.io.*;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numQ = Integer.parseInt(br.readLine().trim());
        for (int q = 0; q < numQ; q++) {
            int sz = Integer.parseInt(br.readLine().trim());
            Robot[] robots = new Robot[sz];
            for (int i = 0; i < robots.length; i++) {
                String[] line = br.readLine().trim().split(" ");
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                int up = Integer.parseInt(line[2]);
                int right = Integer.parseInt(line[3]);
                int down = Integer.parseInt(line[4]);
                int left = Integer.parseInt(line[5]);
                robots[i] = new Robot(x, y, up, right, down, left);
            }
            bw.write(solve(robots) + "\n");
        }

        bw.flush();
    }

    private static String solve(Robot[] robots) {
        int xmin = -100000;
        int xmax = 100000;
        int ymin = -100000;
        int ymax = 100000;
        for (int i = 0; i < robots.length; i++) {
            if(robots[i].up == 0) {
                ymin = Math.max(ymin, robots[i].y);
            }
            if(robots[i].down == 0) {
                ymax = Math.min(ymax, robots[i].y);
            }
            if(robots[i].right == 0) {
                xmax = Math.min(xmax, robots[i].x);
            }
            if(robots[i].left == 0) {
                xmin = Math.max(xmin, robots[i].x);
            }
        }
        if(xmax < xmin || ymax < ymin) return "0";
        return "1 " + xmin + " " + ymin;
    }

    static class Robot {
            int x;
            int y;
            int up;
            int right;
            int down;
            int left;

            Robot(int _x, int _y, int _up, int _right, int _down, int _left) {
                x = _x;
                y = _y;
                up = _up;
                right = _right;
                down = _down;
                left = _left;
            }
    }
}


