class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void helper(int i , ArrayList<Integer>list , int []nums){
        if(i>=nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        //pick
        list.add(nums[i]);
        helper(i+1, list, nums);
        list.remove(list.size()-1);
        //not pick
        helper(i+1,list , nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        helper(0,new ArrayList<>() , nums);
        return res;

    }
}