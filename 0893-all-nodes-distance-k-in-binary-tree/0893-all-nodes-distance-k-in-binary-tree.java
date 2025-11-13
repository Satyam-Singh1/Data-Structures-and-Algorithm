/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        buildParentMap(root, null, map);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        q.add(target);
        vis.add(target);
        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (dist == k)
                break;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                if (curr.left != null && !vis.contains(curr.left)) {
                    vis.add(curr.left);
                    q.add(curr.left);
                }
                if (curr.right != null && !vis.contains(curr.right)) {
                    vis.add(curr.right);
                    q.add(curr.right);
                }

                //--> Checking the parent 
                TreeNode par = map.get(curr);
                if (par != null && !vis.contains(par)) {
                    vis.add(par);
                    q.add(par);
                }
            }

            dist++;
        }

        if (q.isEmpty())
            return new ArrayList<>();

        while (!q.isEmpty()) {
            res.add(q.remove().val);
        }
        return res;

    }

    private void buildParentMap(TreeNode curr, TreeNode par, Map<TreeNode, TreeNode> map) {
        if (curr == null)
            return;
        map.put(curr, par);
        buildParentMap(curr.left, curr, map);
        buildParentMap(curr.right, curr, map);
    }
}