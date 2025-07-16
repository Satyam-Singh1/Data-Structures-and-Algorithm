class Solution {
    
    // Memoization
    
    public int helper(int []coins , int amount , int n,int dp[][] ){

        if(amount==0) return 0;
        if (n < 0) return Integer.MAX_VALUE-1; 
 
        if(dp[n][amount]!=-1){
            return dp[n][amount];
        }

        //Not take
        int notTake = helper(coins , amount , n-1,dp);

        //Take
        int take = Integer.MAX_VALUE-1 ;
        if(amount>=coins[n]){
            take = 1 + helper(coins , amount-coins[n] , n,dp);
        }
      return dp[n][amount]= Math.min(take , notTake);
 
    }
    public int coinChange(int[] coins, int amount) {
         int n=coins.length;
      
      int dp[][] = new int[n][amount+1];
      for(int []x:dp){
        Arrays.fill(x,-1);
      }
    
        int ans= helper(coins , amount , coins.length-1,dp);
        return (ans>=Integer.MAX_VALUE-1)?-1:ans;
    }
}