package cp.practice;

import java.util.Arrays;

public class SuffixArray {
//    static int[] build(String s) {
//        s += "$";
//        Z[] z = new Z[s.length()];
//        for (int i = 0; i < z.length; i++) {
//            z[i] = new Z(s.charAt(i), 0, i);
//        }
//        int[] rank = new int[z.length];
//        sortAndRank(z, rank);
//        for (int j = 0; (1 << j) < s.length(); j++) {
//            for (int i = 0; i < s.length(); i++) {
//                int next = i + (1 << j);
//                z[i] = new Z(rank[i], next < s.length() ? rank[next] : 0, i);
//            }
//            sortAndRank(z, rank);
//        }
//        int[] sa = new int[z.length];
//        for (int i = 0; i < sa.length; i++) {
//            sa[i] = z[i].idx;
//        }
//        return sa;
//    }
//
//    public static void main(String[] args) {
//        int[] sa = build("banana");
//        for (int i = 0; i < sa.length; i++) {
//            System.out.print(sa[i]+ " ");
//        }
//    }
//
//    private static void sortAndRank(Z[] z, int[] rank) {
//        Arrays.sort(z, (z1, z2) -> z1.compareTo(z2));
//        Arrays.fill(rank, 0);
//        for (int i = 0; i < z.length; i++) {
//            int idx = z[i].idx;
//            if(i == 0) {
//                rank[idx] = 0;
//                continue;
//            }
//            rank[idx] = rank[z[i - 1].idx];
//            if(z[i].val != z[i - 1].val) rank[idx]++;
//        }
//    }
//
//    static class Z {
//        int val;
//        int rank;
//        int idx;
//
//        Z(int v, int r, int i) {
//            val = v;
//            rank = r;
//            idx = i;
//        }
//
//
//        public int compareTo(Z z2) {
//            if(val == z2.val) return z2.idx - idx;
//            return val - z2.val;
//        }
//    }

    static int[] buildSuffixArray(String s) {
        s += "$";
        Z[] z = new Z[s.length()];
        int[] rank = new int[s.length()];
        for (int i = 0; i < rank.length; i++) {
            rank[i] = s.charAt(i) - '$';
        }
        for (int i = 0; i < z.length; i++) {
            int nextRank = i + 1 < rank.length ? rank[i + 1] : -1;
            z[i] = new Z(rank[i], nextRank, i);
        }
        sortAndRank(z, rank);
        for(int j = 2; (1 << j) < s.length(); j++) {
            for (int i = 0; i < s.length(); i++) {
                int next = i + (1 << j);
                int nextRank = next < s.length() ? rank[next] : -1;
                z[i] = new Z(rank[i], nextRank, i);
            }
            sortAndRank(z, rank);
        }
        int[] sa = new int[z.length];
        for (int i = 0; i < sa.length; i++) {
            sa[i] = z[i].idx;
        }
        return sa;
    }

    static void sortAndRank(Z[] z, int[] rank) {
        Arrays.sort(z, (z1, z2) -> z1.compareTo(z2));
        for (int i = 0; i < rank.length; i++) {
            int idx = z[i].idx;
            if(i == 0) {
                rank[idx] = 0;
                continue;
            }
            rank[idx] = rank[z[i - 1].idx];
            if(z[i].compareTo(z[i - 1]) > 0)
                rank[idx]++;
        }
    }

    static class Z {
        int rank;
        int nextRank;
        int idx;

        Z(int r, int n, int i) {
            rank = r;
            nextRank = n;
            idx = i;
        }

        int compareTo(Z other) {
            if(rank == other.rank) return nextRank - other.nextRank;
            return rank - other.rank;
        }
    }

    public static void main(String[] args) {
        int[] sa = buildSuffixArray("random");
        for (int i = 0; i < sa.length; i++) {
            System.out.print(sa[i]+ " ");
        }
    }
}
