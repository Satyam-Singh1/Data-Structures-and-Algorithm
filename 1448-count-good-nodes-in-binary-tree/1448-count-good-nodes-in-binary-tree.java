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
    public int helper(TreeNode root, int maxi) {
        if (root == null) {
            return 0;
        }
        int cnt = 0;
        if (root.val >= maxi) {
            cnt = 1;
        }
        maxi = Math.max(maxi, root.val);
        int leftCnt = helper(root.left, maxi);
        int rightCnt = helper(root.right, maxi);
        return cnt + leftCnt + rightCnt;

    }

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, root.val);
    }
}