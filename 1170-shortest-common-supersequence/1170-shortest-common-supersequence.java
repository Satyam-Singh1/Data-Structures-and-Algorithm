class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder str = new StringBuilder();
        int lent = dp[n][m];
        while (n > 0 && m > 0) {
            if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                str.append(s1.charAt(n - 1));
                n--;
                m--;
            } else if (dp[n - 1][m] < dp[n][m - 1]) {
                str.append(s1.charAt(n - 1));
                n--;
            } else {
                str.append(s2.charAt(m - 1));
                m--;
            }
        }
        while (n > 0) {
            str.append(s1.charAt(n - 1));
            n--;
        }
        while (m > 0) {
            str.append(s2.charAt(m - 1));
            m--;
        }
        return str.reverse().toString();

    }
}