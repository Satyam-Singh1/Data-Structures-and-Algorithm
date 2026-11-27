class Solution {
    public void dfs(int r , int c , char[][]grid){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]=='0'){
            return;
        }
        // Mark as visited
        grid[r][c] = '0';
        dfs(r+1,c,grid);
        dfs(r,c+1,grid);
        dfs(r-1,c,grid);
        dfs(r,c-1,grid);
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for(int i = 0 ; i < n  ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    dfs(i,j,grid);
                }
            }
        }
        return cnt;
    }
}