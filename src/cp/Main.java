package cp;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = "3";
        String s2 = "3";
        System.out.println(s == s2);
//        String[] parts = s.split("[-]+");
//        for(String p: parts) {
//            bw.write(p + "\n");
//        }
//        bw.write(parts.length + "\n");
//        parts = s.split("\\d+");
//        for(String p: parts) {
//            bw.write(p + "\n");
//        }
//        bw.write(parts.length + "\n");
        bw.flush();
    }

}
