class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l =  0;
        int h = n-1;
        int ans = Integer.MAX_VALUE;
        while(l<=h){
            int mid = l + (h-l)/2;
            ans = Math.min(ans, nums[mid]);
            if(nums[mid]>=nums[h]){
                l = mid+1;
            } else{
                h = mid-1;
            }
        }
        return ans;
    }
}