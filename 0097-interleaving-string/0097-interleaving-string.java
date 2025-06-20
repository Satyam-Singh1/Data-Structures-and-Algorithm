class Solution {
    Boolean[][][] dp = new Boolean[101][101][201];

    private boolean solve(int i, int j, int k, String s1, String s2, String s3) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if (k >= s3.length()) return false;

        if (dp[i][j][k] != null) return dp[i][j][k];

        boolean result = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = result || solve(i + 1, j, k + 1, s1, s2, s3);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            result = result || solve(i, j + 1, k + 1, s1, s2, s3);
        }

        return dp[i][j][k] = result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length();
        if (n + m != s3.length()) return false;
        return solve(0, 0, 0, s1, s2, s3);
    }
}
