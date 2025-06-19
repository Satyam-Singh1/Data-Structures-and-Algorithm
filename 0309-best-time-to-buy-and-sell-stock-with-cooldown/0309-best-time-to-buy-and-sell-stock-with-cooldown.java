class Solution {
    public int solve(int n , int []prices , int flag , int [][]dp){
       
       if(n>=prices.length) return 0;
       if(dp[n][flag]!=-1) return dp[n][flag];
       int profit = 0;
       if(flag==1){
         int buy = -prices[n] + solve(n+1 , prices , 0 ,dp );
         int notBuy = solve(n+1 , prices , 1,dp);
         profit = Math.max(buy , notBuy);
       }
       else{
        int sell = prices[n] + solve(n+2 , prices ,1,dp);
        int notSell = solve(n+1 , prices , 0,dp);
        profit = Math.max(notSell , sell);
       }
       return dp[n][flag] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int flag = 1;
        int  [][]dp = new int [n][2];
        for(int []x:dp) Arrays.fill(x,-1);
        return solve(0 , prices , flag , dp);
        
        

    }
}