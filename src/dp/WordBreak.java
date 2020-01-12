package dp;

import java.util.HashSet;
import java.util.Set;

class WordBreak {
    public static void main(String args[]) {
        WordBreak obj = new WordBreak();

        Set<String> s = new HashSet<>();
        s.add("interview");
        s.add("my");
        s.add("trainer");
        obj.solveWordBreak("myinterviewtrainer", s);
    }

    public void solveWordBreak(String word, Set<String> dictionary) {
        boolean[][] dp = new boolean[word.length()][word.length()];
        for (int i = 0; i < dp.length; i++) {
            if (dictionary.contains(word.substring(i, i + 1)))
                dp[i][i] = true;
        }
        for (int m = 2; m <= dp.length; m++) {
            for (int n = 0; n < dp.length - m + 1; n++) {
                int j = n + m - 1;
                if (dictionary.contains(word.substring(n, j + 1))) {
                    dp[n][j] = true;
                    continue;
                }
                for (int k = n + 1; k <= j; k++) {
                    if (dp[n][k - 1] && dp[k][j]) {
                        dp[n][j] = true;
                        break;
                    }
                }
            }
        }
        System.out.println(dp[0][dp[0].length - 1] ? "Possible" : "Not possible");
    }
}
