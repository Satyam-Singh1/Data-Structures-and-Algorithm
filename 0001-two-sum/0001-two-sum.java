class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i = 0 ; i < n;  i++){
            int curr = nums[i];
            int rem = target - curr;
            if(map.containsKey(rem)){
                return new int[]{i,map.get(rem)};
            }
            map.put(curr,i);
           
        }
        return new int[]{};
    }
}