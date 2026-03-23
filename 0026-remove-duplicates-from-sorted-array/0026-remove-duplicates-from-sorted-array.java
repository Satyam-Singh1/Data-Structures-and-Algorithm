class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        int j = 0;
        int cnt = 1;
        for(int i = 1 ; i < n ; i++){
            int curr = nums[i];
            if(curr!=nums[j]){
                nums[j+1]=curr;
                j++;
                
            }

        }
        return j+1;
    }
}