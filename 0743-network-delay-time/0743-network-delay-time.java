class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
    
        int []dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        // Bellman ford algorithm
        for(int i = 0 ; i < n-1 ; i++){
            for(int []curr:times){

            int u = curr[0];
            int v = curr[1];
            int d = curr[2];
            if(dist[u]!=Integer.MAX_VALUE && dist[u]+d<dist[v]){
                dist[v] = dist[u] + d;
            }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 1; i<=n ; i++){
           if(dist[i]==Integer.MAX_VALUE){
            return -1;
           }
            res = Math.max(res ,dist[i]);
        }
        return res;

    }
}