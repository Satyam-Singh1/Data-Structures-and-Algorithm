class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < n ; i++){
            int currProfit = prices[i]-min;
            maxProfit = Math.max(maxProfit,currProfit);
            min = Math.min(prices[i],min);
        }
        return maxProfit;
    }
}