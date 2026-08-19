class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0 ; i <n ; i++){
           currSum = currSum+nums[i];
           maxSum = Math.max(maxSum,currSum);
           currSum = Math.max(0,currSum);
        } 
        return maxSum;

    }
}