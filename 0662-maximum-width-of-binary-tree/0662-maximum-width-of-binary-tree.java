class Solution {
    class Pair {
        long index;
        TreeNode node;
        Pair(TreeNode n, long i) {
            index = i;
            node = n;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        long maxi = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            long minIndex = q.peek().index;  
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair curr = q.remove();
                long currIndex = curr.index - minIndex;  // avoid overflow

                if (i == 0) first = currIndex;
                if (i == size - 1) last = currIndex;

                if (curr.node.left != null)
                    q.add(new Pair(curr.node.left, 2 * currIndex + 1));
                if (curr.node.right != null)
                    q.add(new Pair(curr.node.right, 2 * currIndex + 2));
            }

            maxi = Math.max(maxi, last - first + 1);
        }

        return (int) maxi;
    }
}
