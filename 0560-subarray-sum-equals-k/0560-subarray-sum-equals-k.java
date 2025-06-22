class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        int currSum = 0 ;
        int cnt = 0;
        int r =0;
        while(r<n){
            currSum+=nums[r];
           
            int diff = currSum - k;
            if(map.containsKey(diff)){
                cnt+=map.get(diff);
            }
             map.put(currSum , map.getOrDefault(currSum , 0)+1);
            r++;
        }
        return cnt;
    }
}