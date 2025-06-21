class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0 ;
        int minLen = Integer.MAX_VALUE;
        int r = 0 , l = 0;
        while(r<n){
            sum+=nums[r];
            while(sum>=target){
                minLen = Math.min(minLen , r-l+1);
                sum-=nums[l];
                l++;
            }
            r++;
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}