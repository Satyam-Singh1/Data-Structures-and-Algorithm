class Solution {
    private int helper(int n, int[] dp) {
        if (n <= 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        return dp[n];
    }

    public int climbStairs(int n) {
        if (n <= 1)
            return 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        dp[0] = 1;

        return helper(n, dp);
    }
}