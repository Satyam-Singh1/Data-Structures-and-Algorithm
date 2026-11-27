class Solution {
    List<List<Integer>>adj = new ArrayList<>();
    public boolean dfs(int node , int target , int []vis){
        if(node==target) return true;

        vis[node] = 1;
        for(int neig : adj.get(node)){
            if(vis[neig]==0){
                if(dfs(neig , target , vis)) return true;
            }
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int m = edges[0].length;
        
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge : edges){
            int u = edge[0];
            int v = edge[1];

            int []vis = new int[n+1];
            if(dfs(u,v, vis)){
                return new int[]{u,v};
            }


            //else
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[]{-1,-1};
    }
}