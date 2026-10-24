class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void helper(int idx, int sum, List<Integer> curr,
                       int[] candidates, int target) {

        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (idx >= candidates.length || sum > target) {
            return;
        }

        // Take the current candidate
        curr.add(candidates[idx]);
        helper(idx + 1, sum + candidates[idx],
               curr, candidates, target);
        curr.remove(curr.size() - 1);

        // Not take: skip all duplicates of this candidate
        int next = idx + 1;
        while (next < candidates.length &&
               candidates[next] == candidates[idx]) {
            next++;
        }

        helper(next, sum, curr, candidates, target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates,
                                                int target) {
        Arrays.sort(candidates);
        res.clear();

        helper(0, 0, new ArrayList<>(), candidates, target);
        return res;
    }
}