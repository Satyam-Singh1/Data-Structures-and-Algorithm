class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int maxCnt = 0;
        for (int curr : set) {
            if (!set.contains(curr - 1)) {
                int temp = 1;
                int st = curr;
                while (set.contains(st + 1)) {
                    temp++;
                    st = st + 1;
                }
                maxCnt = Math.max(maxCnt, temp);
            }

        }
        return maxCnt;
    }
}