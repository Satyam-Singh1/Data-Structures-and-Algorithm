class Solution {
    private int solve(int n, int flag, int fee, int[] prices) {
        if (n == prices.length)
            return 0;
        int profit = 0;
        //Buy
        if (flag == 1) {
            int buy = -prices[n] + solve(n + 1, 0, fee, prices);
            int skip = solve(n + 1, 1, fee, prices);
            profit = Math.max(buy, skip);
        } else {
            int sell = prices[n] - fee + solve(n + 1, 1, fee, prices);
            int skip = solve(n + 1, 0, fee, prices);
            profit = Math.max(sell, skip);
        }
        return profit;

    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        //  int flag =1;

        //  return solve(0 , flag, fee , prices);
        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int flag = 0; flag <= 1; flag++) {
                int profit = 0;
                //Buy
                if (flag == 1) {
                    int buy = -prices[i] + dp[i + 1][0];
                    int skip = dp[i + 1][1];
                    profit = Math.max(buy, skip);
                } else {
                    int sell = prices[i] - fee + dp[i + 1][1];
                    int skip = dp[i + 1][0];
                    profit = Math.max(sell, skip);
                }
                dp[i][flag] = profit;
            }
        }
        return dp[0][1];
    }
}