class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = n-1;
        int i = n-1;
        while(i>=0){
            if(nums[i]==0){
                for(int k = i ; k<j ; k++){
                    if(k!=n) nums[k] = nums[k+1];
                   
                }
                nums[j]=0;
                j--;
            }
            i--;
        }
        
    }
}