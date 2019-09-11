package cp.codeforces.round572;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        String[] line = br.readLine().trim().split(" ");
        int[] nums = new int[line.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }
        Ans[][] solutions = buildSolutions(nums);
        int numQ = Integer.parseInt(br.readLine().trim());
        for (int q = 0; q < numQ; q++) {
            String[] query = br.readLine().trim().split(" ");
            int low = Integer.parseInt(query[0]);
            int high = Integer.parseInt(query[1]);
            bw.write(solve(low, high, solutions) + "\n");
        }
        bw.flush();

    }

    private static Ans[][] buildSolutions(int[] nums) {
        Ans[][] solutions = new Ans[log2(nums.length) + 1][nums.length];
        for (int i = 0; i < nums.length; i++) {
            solutions[0][i] = new Ans(0, nums[i]);
        }
        for (int level = 1; level < solutions.length; level++) {
            for (int i = 0; i + (1 << (level - 1)) < nums.length; i++) {
                int col = i + (1 << (level - 1));
                if(solutions[level - 1][col] != null) {
                    int sum = solutions[level - 1][i].value + solutions[level - 1][col].value;
                    int count = solutions[level - 1][i].count
                            + solutions[level - 1][col].count
                            + sum / 10;
                    int value = sum % 10;
                    solutions[level][i] = new Ans(count, value);
                }
            }
        }
        return solutions;
    }

    private static int solve(int low, int high, Ans[][] solutions) {
        int length = high - low + 1;
        int level = log2(length);
        return solutions[level][low - 1].count;
    }

    private static int log2(int n) {
        int count = 0;
        while(n != 1) {
            n /= 2;
            count++;
        }
        return count;
    }

    static class Ans {
        int count;
        int value;

        Ans(int c, int v) {
            count = c;
            value = v;
        }
    }
}

