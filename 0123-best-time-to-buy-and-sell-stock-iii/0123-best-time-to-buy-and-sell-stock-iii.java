class Solution {
    //MEMOIZATION
    public int helper(int[] prices, int idx, int buy, int cap, int[][][] dp) {
        if (cap == 0 || idx == prices.length) {
            return 0;
        }
        if (dp[idx][buy][cap] != -1)
            return dp[idx][buy][cap];
        int profit = 0;
        if (buy == 1) {
            int take = -prices[idx] + helper(prices, idx + 1, 0, cap, dp);
            int notTake = 0 + helper(prices, idx + 1, 1, cap, dp);
            profit = Math.max(take, notTake);
        } else {
            int sell = prices[idx] + helper(prices, idx + 1, 1, cap - 1, dp);
            int notSell = 0 + helper(prices, idx + 1, 0, cap, dp);
            profit = Math.max(sell, notSell);
        }
         return dp[idx][buy][cap] = profit;
        
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int[][] x : dp) {
            for (int[] y : x) {
                Arrays.fill(y, -1);
            }
        }
        return helper(prices, 0, 1, 2, dp);
    }
}