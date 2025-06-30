class Solution {
    public int findParent(int x , int []parent){
        if(x==parent[x]) return x;
        return parent[x] = findParent(parent[x] , parent);
    }
    public boolean union(int x , int y , int  []parent , int []rank){
         int xPar = findParent(x,parent);
         int yPar = findParent(y , parent);
         if(xPar==yPar) return false;
         int xRank = rank[xPar];
         int yRank = rank[yPar];
         if(xRank > yRank){
            parent[yPar] = parent[xPar];
         }
         else if(yRank > xRank){
            parent[xPar] = parent[yPar];
         }else{
            parent[xPar] = parent[yPar];
            rank[yPar]++;
         }
         return true;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
         int m = edges.length;
           int []parent = new int[n];
           int []rank = new int[n];
           for(int i = 0 ; i < n ; i++){
              parent[i] = i;
           }
        for(int i = 0 ; i < m ; i++){
            int x =  edges[i][0];
            int y = edges[i][1];
            union(x,y,parent , rank);
        }
        return  findParent(source , parent)==findParent(destination , parent);
    }
}