class Solution {
    class Tuple {
        TreeNode node;
        int hd;   // horizontal distance
        int level; // depth level

        Tuple(TreeNode n, int h, int l) {
            node = n;
            hd = h;
            level = l;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        // HD -> Level -> MinHeap of node values
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple x = q.poll();
            TreeNode node = x.node;
            int hd = x.hd;
            int level = x.level;

            map.putIfAbsent(hd, new TreeMap<>());
            map.get(hd).putIfAbsent(level, new PriorityQueue<>());
            map.get(hd).get(level).offer(node.val);

            if (node.left != null) {
                q.offer(new Tuple(node.left, hd - 1, level + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, hd + 1, level + 1));
            }
        }

        // Build the result from the map
        for (TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : levels.values()) {
                while (!nodes.isEmpty()) {
                    col.add(nodes.poll());
                }
            }
            list.add(col);
        }

        return list;
    }
}
