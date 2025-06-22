    class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            int n = nums.length;
            Map<Integer , Integer>map = new HashMap<>();
            map.put(0,1);
            int currSum = 0;
            int cnt = 0;
            int r=0; 
            while(r<n){
                currSum+=nums[r];
                int remainder = currSum%k;
                if(remainder<0)remainder+=k;
                if(map.containsKey(remainder)){
                    cnt+=map.get(remainder);
                }
                map.put(remainder , map.getOrDefault(remainder , 0)+1);
                r++;
            }
            return cnt;
        }
    }