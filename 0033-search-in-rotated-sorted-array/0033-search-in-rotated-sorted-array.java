class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0 ; 
        int h = n-1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(nums[mid]==target) return mid;
            //check which half is sorted
            //left half
            if(nums[l]<=nums[mid]){
                if(target>=nums[l] && target<= nums[mid]){
                    h = mid-1;
                }else{
                    l = mid+1;
                }
            }
            //right half 
            else{
                if(nums[mid]<=target && nums[h]>=target){
                    l = mid+1;
                }else{
                    h = mid-1;
                }
            }
            
        }
        return -1;
    }
}