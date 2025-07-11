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
    private void swap(TreeNode left ,TreeNode right , TreeNode root){
      
        TreeNode temp = left;
        root.left = right;
        root.right = temp;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root ==null) return null;
        swap(root.left , root.right , root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}