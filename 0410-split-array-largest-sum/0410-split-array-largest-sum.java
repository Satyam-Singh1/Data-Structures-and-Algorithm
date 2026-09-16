    class Solution {
        public boolean isFeasible(int mid , int nums[] , int k){
            int currSum = 0;
            int subarrayCnt = 1;
            for(int i = 0 ; i<nums.length; i++){
                if(currSum+nums[i]>mid){
                    subarrayCnt++;
                    currSum = 0;
                }
                
                    currSum+=nums[i];
                
            }
            return subarrayCnt<=k;
        }
        public int splitArray(int[] nums, int k) {
            int n = nums.length;
            int l = 0;
            int h = 0;
            for(int x:nums){
                h+=x;
                l = Math.max(l,x);
            }
            while(l<=h){
                int mid = l + (h-l)/2;
                if(isFeasible(mid,nums,k)){
                    h = mid-1;
                }else{
                    l = mid+1;
                }
            }
            return l;
        }  
    }