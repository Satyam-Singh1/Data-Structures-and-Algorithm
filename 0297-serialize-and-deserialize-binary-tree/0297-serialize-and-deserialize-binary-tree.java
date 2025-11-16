/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();

        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                str.append("null ");
                continue;
            }
            str.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);

        }
        return str.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while (!q.isEmpty()) {
            if (i >= values.length)
                break;

            TreeNode curr = q.remove();

            // left child
            if (!values[i].equals("null")) {
                TreeNode temp = new TreeNode(Integer.parseInt(values[i]));
                curr.left = temp;
                q.add(temp);
            }
            i++;
            if (!values[i].equals("null")) {
                TreeNode temp = new TreeNode(Integer.parseInt(values[i]));
                curr.right = temp;
                q.add(temp);
            }
            i++;
        }

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));