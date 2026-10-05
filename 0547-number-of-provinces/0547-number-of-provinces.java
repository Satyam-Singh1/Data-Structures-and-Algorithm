class Solution {
    public void bfs(int start, int[][] isConnected, int[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = 1;
        int n = isConnected.length;
        while (!q.isEmpty()) {
            int node = q.poll();

            // CHECKING neighbour
            for (int i = 0; i < n; i++) {
                if (isConnected[node][i] == 1) {
                    if (vis[i] == 0) {
                        q.add(i);
                        vis[i] = 1;
                    }
                }

            }

        }

    }

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        int vis[] = new int[n];
        for (int i = 0; i < isConnected.length; i++) {
            if (vis[i] == 0) {
                count++;
                bfs(i, isConnected, vis);
            }
        }
        return count;
    }
}