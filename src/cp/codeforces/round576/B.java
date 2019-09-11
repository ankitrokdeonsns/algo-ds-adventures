package cp.codeforces.round576;

import java.io.*;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().trim().split(" ");
        long h = Long.parseLong(line[0]);
        long l = Long.parseLong(line[1]);

        bw.write((l * l - h * h) / (2.0 * h) + "\n");

        bw.flush();
    }
}

