class Solution {
    public int helper(int i , int []nums, int []dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        // take curr
        int take = nums[i]+helper(i+2 , nums, dp);
        //skip curr
        int skip = helper(i+1 , nums ,dp);
        return dp[i] = Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(0 , nums , dp);
    }
}