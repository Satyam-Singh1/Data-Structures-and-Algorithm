class Solution {

    public boolean dfs(int v, int end, List<List<Integer>> adj, int[] vis) {

        if (v == end) {
            return true;
        }

        vis[v] = 1;

        for (int x : adj.get(v)) {
            if (vis[x] == 0) {
                if (dfs(x, end, adj, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];

        return dfs(source, destination, adj, vis);
    }
}