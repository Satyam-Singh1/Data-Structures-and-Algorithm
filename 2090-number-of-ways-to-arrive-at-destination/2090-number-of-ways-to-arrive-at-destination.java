import java.util.*;

class Solution {
    static final int MOD = (int)1e9 + 7;

    class Pair {
        int node;
        long dist;  // ✅ Make distance long to match dist[]

        Pair(long dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }

    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt}); // since undirected
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        pq.offer(new Pair(0L, 0)); 

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            long d = curr.dist;

            if (d > dist[node]) continue;

            for (int[] next : adj.get(node)) {
                int adjNode = next[0];
                int wt = next[1];

                if (dist[adjNode] > dist[node] + wt) {
                    dist[adjNode] = dist[node] + wt;
                    pq.offer(new Pair(dist[adjNode], adjNode));  
                    ways[adjNode] = ways[node];
                } else if (dist[adjNode] == dist[node] + wt) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
