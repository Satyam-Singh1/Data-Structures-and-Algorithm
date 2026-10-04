class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void helper(int idx, ArrayList<Integer> list, int[] nums) {
        res.add(new ArrayList<>(list));
        //  instead of increamenting idx in helper we are doing in loop
        for (int i = idx; i < nums.length; i++) {
            // if duplicate ignore that
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            helper(i+1, list, nums);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        helper(0, new ArrayList<>(), nums);
        return res;
    }
}