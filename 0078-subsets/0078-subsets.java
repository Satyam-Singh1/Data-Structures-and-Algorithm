class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void solve(int idx , int []nums , ArrayList<Integer>curr ){
        if(idx>=nums.length){
        //    List<Integer>temp = new ArrayList<>(curr);
           res.add(new ArrayList<>(curr));
            return;
        }
       
       solve(idx+1 , nums , curr);

        curr.add(nums[idx]);
       solve(idx+1 , nums ,curr);
       curr.remove(curr.size()-1);
       

       
    }

    public List<List<Integer>> subsets(int[] nums) {
        solve(0, nums, new ArrayList<>());
        return res;
    }
}