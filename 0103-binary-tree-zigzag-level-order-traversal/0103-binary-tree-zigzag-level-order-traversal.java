/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int currSize = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < currSize; i++) {
                TreeNode currNode = q.remove();
                temp.add(currNode.val);
                if (currNode.left != null)
                    q.add(currNode.left);
                if (currNode.right != null)
                    q.add(currNode.right);
            }
            if (!flag) {
                Collections.reverse(temp);
            }
            flag = !flag;
            res.add(temp);
        }
        return res;
    }
}