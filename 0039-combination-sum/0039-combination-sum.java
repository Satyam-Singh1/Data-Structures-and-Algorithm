class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public void helper(int n, int target, List<Integer> curr, int[] arr) {
        if(n>=arr.length) return;
        if (target == 0) {
            list.add(new ArrayList<>(curr));
            return;
        }
        //pick
        if (arr[n] <= target) {
            curr.add(arr[n]);
            helper(n, target - arr[n], curr, arr);
            curr.remove(curr.size()-1);
        }
        helper(n+1 , target , curr ,arr);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(0, target, new ArrayList<>(),candidates);
        return list;
    }
}