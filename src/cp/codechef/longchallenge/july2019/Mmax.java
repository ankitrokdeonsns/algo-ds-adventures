package cp.codechef.longchallenge.july2019;

import java.io.*;
import java.math.BigInteger;

public class Mmax {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numT = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < numT; t++) {
            BigInteger n = new BigInteger(br.readLine().trim());
            BigInteger k = new BigInteger(br.readLine().trim());
            bw.write(solve2(n, k) + "\n");
        }
        bw.flush();
    }

    private static BigInteger solve2(BigInteger n, BigInteger k) {
        BigInteger numChocolatesPerPerson = k.divide(n).max(BigInteger.valueOf(1));
        BigInteger numPersonsWithChocolates = k.divide(numChocolatesPerPerson);
        BigInteger remainingChocolates = k.subtract(numChocolatesPerPerson.multiply(numPersonsWithChocolates));
        BigInteger numPesonsWithNoChocolates = n.subtract(numPersonsWithChocolates).subtract(BigInteger.valueOf(1));

        int compare = numPesonsWithNoChocolates.add(BigInteger.valueOf(1)).compareTo(numPersonsWithChocolates);
        BigInteger diff = numChocolatesPerPerson.max(remainingChocolates)
                            .subtract(numChocolatesPerPerson.min(remainingChocolates));
        if(compare < 0) {
            BigInteger a =  numPesonsWithNoChocolates.multiply(BigInteger.valueOf(2)).multiply(numPersonsWithChocolates);
            BigInteger b = diff.multiply(BigInteger.valueOf(2));
            return a.add(b);
        } else if(compare == 0) {
            BigInteger a =  numPesonsWithNoChocolates.multiply(BigInteger.valueOf(2)).multiply(numPersonsWithChocolates);
            return a.add(diff);
        } else {
            BigInteger a = numPersonsWithChocolates
                                .subtract(BigInteger.valueOf(1))
                                .multiply(numPersonsWithChocolates)
                                .multiply(BigInteger.valueOf(2))
                                .add(numPersonsWithChocolates);
            BigInteger b = diff;
            if(numPesonsWithNoChocolates.compareTo(numPersonsWithChocolates) > 0)
                b = b.add(diff);
            return a.add(b);
        }

    }

    private static BigInteger solve(BigInteger n, BigInteger k) {
        BigInteger numChocolatesPerPerson = k.divide(n);
        BigInteger remainder = k.remainder(n);
        BigInteger ONE = BigInteger.valueOf(1);
        BigInteger TWO = BigInteger.valueOf(2);

        if(!remainder.equals(BigInteger.valueOf(0)))
            numChocolatesPerPerson = numChocolatesPerPerson.add(ONE);

        BigInteger numPersonsWithChocolates = k.divide(numChocolatesPerPerson);
        BigInteger numPersonsWithNoChocolates = n.subtract(numPersonsWithChocolates);
        BigInteger numPairs = numPersonsWithNoChocolates.min(numPersonsWithChocolates);

        BigInteger ans = numPairs.subtract(ONE)
                                    .multiply(TWO)
                                    .multiply(numChocolatesPerPerson);
        ans = ans.add(numChocolatesPerPerson);
        if(numPairs.compareTo(numPersonsWithChocolates) == -1)
            ans = ans.add(numChocolatesPerPerson);
        return ans;
    }
}
