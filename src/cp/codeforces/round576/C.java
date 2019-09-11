 package cp.codeforces.round576;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().trim().split(" ");
        int totalBitsAvailable = Integer.parseInt(line[1]) * 8;
        String[] line2 = br.readLine().trim().split(" ");
        int[] nums =  new int[line2.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(line2[i]);
        }

        bw.write(solve(nums, totalBitsAvailable) + "\n");

        bw.flush();
    }

    private static int solve(int[] nums, int totalBitsAvailable) {
        Map<Integer, Integer> countMap =  new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(countMap.containsKey(nums[i])) {
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            } else {
                countMap.put(nums[i], 1);
            }
        }
        Arrays.sort(nums);

        int bitsPerValueAvailable = totalBitsAvailable / nums.length;
        int numDistinctValuesCanBeStored = 1 << (totalBitsAvailable / nums.length);
        int numDistinctValues = countMap.keySet().size();
        int deleteCount = 0;
        int low = 0;
        int high = nums.length - 1;
        while(bitsRequiredPerValue(numDistinctValues) > bitsPerValueAvailable && low <= high && low < nums.length && high >= 0) {
            if(countMap.get(nums[low]) < countMap.get(nums[high])) {
                deleteCount += countMap.get(nums[low]);
                low += countMap.get(nums[low]);
            } else {
                deleteCount += countMap.get(nums[high]);
                high -= countMap.get(nums[high]);
            }
            numDistinctValues--;
        }
        return deleteCount;
    }

    private static int bitsRequiredPerValue(int n) {
        return (int) Math.ceil(Math.log(n) / Math.log(2));
    }
}
