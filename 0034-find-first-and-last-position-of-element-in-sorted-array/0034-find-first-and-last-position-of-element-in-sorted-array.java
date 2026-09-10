class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = {-1,-1};
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (l < n && nums[l] == target) {
            ans[0] = l;
        }
        l = 0;
        h = n - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (h >= 0 && nums[h] == target) {
            ans[1] = h;
        }
        return ans;
    }
}