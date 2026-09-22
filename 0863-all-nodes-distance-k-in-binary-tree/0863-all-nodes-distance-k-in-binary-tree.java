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
    HashMap<TreeNode, TreeNode> map = new HashMap<>();

    public void buildParent(TreeNode root, TreeNode parent) {
        if (root == null)
            return;
        map.put(root, parent);
        buildParent(root.left, root);
        buildParent(root.right, root);
    }

    public List<Integer> helper(TreeNode root, int k, List<Integer> list) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        set.add(root);
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if(cnt==k){
                for(int i = 0; i<size ; i++){
                   TreeNode curr = q.poll();
                   list.add(curr.val);
                }
                break;
            }
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
               if(curr.left!=null && !set.contains(curr.left)){
                 q.offer(curr.left);
                 set.add(curr.left);
               }
                if(curr.right!=null && !set.contains(curr.right)){
                 q.offer(curr.right);
                 set.add(curr.right);
               }
               TreeNode parent = map.get(curr);
                if(parent!=null && !set.contains(parent)){
                 q.offer(parent);
                 set.add(parent);
               }
    
            }
            cnt++;

        }
        return list;
    }

    Set<TreeNode> set = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildParent(root, null);

        List<Integer> res = new ArrayList<>();
        return helper(target, k, res);
    }
}