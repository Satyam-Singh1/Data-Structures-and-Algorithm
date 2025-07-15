class Solution {
    int[][] dp;

    public int lcs(String s1, String s2, int n, int m) {
        if (n < 0)
            return m + 1;
        if (m < 0)
            return n + 1;

        if (dp[n][m] != -1)
            return dp[n][m];

        if (s1.charAt(n) == s2.charAt(m)) {
            dp[n][m] = lcs(s1, s2, n - 1, m - 1);
        } else {
            dp[n][m] = 1 + Math.min(lcs(s1, s2, n - 1, m), Math.min(lcs(s1, s2, n, m - 1), lcs(s1, s2, n - 1, m - 1)));
        }

        return dp[n][m];
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return lcs(word1, word2, n - 1, m - 1);

    }
}
