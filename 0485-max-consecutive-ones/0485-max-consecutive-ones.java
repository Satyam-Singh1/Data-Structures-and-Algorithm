class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // Sliding window approach
        int n = nums.length;
        int l = 0;
        int r = 0;
        int maxi = 0;
        while (r < n) {

            if (nums[r] == 0) {
                l = r + 1;
            } else {
                maxi = Math.max(maxi, r - l + 1);
            }
            r++;
        }
        return maxi;
    }
}