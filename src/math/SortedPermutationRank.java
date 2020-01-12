package math;

public class SortedPermutationRank {
    private static final int M = 1000003;
    private static int[] totalFact;

    public static void main(String[] args) {
        System.out.println(findRank("acb"));
    }

    private static void fillFactorials(int l) {
        totalFact = new int[l + 1];
        totalFact[0] = 1;
        for (int i = 1; i <= l; i++) {
            totalFact[i] = (totalFact[i - 1] * i) % M;
        }
    }

    private static int findRank(String a) {
        int len = a.length();
        fillFactorials(len);

        int[] chars = new int[256];
        for (int i = 0; i < a.length(); i++) {
            byte c = (byte) a.charAt(i);
            chars[c]++;
        }

        int res = 1;
        for (int i = 0; i < len; i++) {
            int lessThan = 0;
            for (int j = 0; j < (byte) a.charAt(i); j++) {
                lessThan += chars[j];
            }
            res += totalFact[len - i - 1] * lessThan % M;
            chars[a.charAt(i)] = 0;
        }
        return res % M;
    }
}
