class Solution {
    public int findParent(int x, int[] parent) {
        if (x == parent[x])
            return x;
        return parent[x] = findParent(parent[x], parent);
    }

    public boolean union(int x, int y, int[] parent, int[] rank) {
        int xPar = findParent(x, parent);
        int yPar = findParent(y, parent);
        if (xPar == yPar)
            return false;
        int xRank = rank[xPar];
        int yRank = rank[yPar];
        if (xRank > yRank) {
            parent[yPar] = parent[xPar];
        } else if (yRank > xRank) {
            parent[xPar] = parent[yPar];
        } else {
            parent[xPar] = parent[yPar];
            rank[yPar]++;
        }
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int []ans = new int[2];
        for (int i = 0; i < n; i++) {
            if (!union(edges[i][0], edges[i][1], parent, rank)) {
              ans[0] = edges[i][0];
              ans[1]= edges[i][1];
              }
            }
        
        return ans;
    }
}