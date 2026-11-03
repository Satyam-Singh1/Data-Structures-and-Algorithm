class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1;
            int h = n - 1;
            while (l < h) {
                int sum = nums[l] + nums[h] + nums[i];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[l], nums[h], nums[i]));
                    l++;
                    h--;
                    while (l < h && nums[l] == nums[l - 1])
                        l++;
                    while (l < h && nums[h] == nums[h + 1])
                        h--;
                } else if (sum < 0) {
                    l++;
                } else {
                    h--;
                }
            }
        }
        return res;
    }
}