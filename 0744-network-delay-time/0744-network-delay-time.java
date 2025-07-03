class Solution {
    class Pair {
        int d;
        int node;

        Pair(int di, int n) {
            d = di;
            node = n;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->a.d-b.d);
        pq.add(new Pair(0,k));
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];
            adj.get(u).add(new int[] { v, wt });
        }

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int distance = curr.d;
            for (int[] x : adj.get(node)) {
                int adjNode = x[0];
                int wt = x[1];
                if (distance + wt < dist[adjNode]) {
                    dist[adjNode] = distance + wt;
                    pq.offer(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dist[i]);
        }
        return max;

    }
}