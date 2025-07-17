class Solution {
    // USING SIMPLE DFS WITH SOME MODIFICATION
    class Pair {
        int node;
        int dist;

        Pair(int n, int d) {
            node = n;
            dist = d;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] x : flights) {
            int u = x[0];
            int v = x[1];
            int wt = x[2];
            adj.get(u).add(new Pair(v, wt));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));

        int distance[] = new int[n];
        Arrays.fill(distance, (int) 1e9);
        distance[src] = 0;
        
        int stops = 0;
        while (!q.isEmpty() && k >= stops) {

            int size = q.size();
            while (size-- > 0) {
                Pair p = q.remove();
                int node = p.node;
                int d = p.dist;
                for (Pair x : adj.get(node)) {
                    int nn = x.node;
                    int nd = x.dist;
                    if (d + nd < distance[nn]) {
                        distance[nn] = d + nd;
                        q.add(new Pair(nn, distance[nn]));
                    }
                }

            }
            stops++;
        }
        int ans = distance[dst] == (int) 1e9 ? -1 : distance[dst];
        return ans;
    }
}