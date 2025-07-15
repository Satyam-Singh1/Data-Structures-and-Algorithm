class Solution {
    int [][]dp;
    public int solve(int r , int c , int m , int n){
        if(r==m-1 && c==n-1) return 1;
         if(r>=m || c>=n) return 0;
         if(dp[r][c]!=-1){
            return dp[r][c];
         }
         
         int down = solve(r+1,c,m,n);
         int right = solve(r,c+1,m,n);
         return dp[r][c]=down+right;
    }
    public int uniquePaths(int m, int n) {
        dp  = new int[m][n];
         for(int []x:dp){
            Arrays.fill(x,-1);
         }
        return solve(0 , 0 , m , n);
        // int [][]dp = new int[m][n];
        // for(int i = 0 ; i < n ; i++){
        //     dp[m-1][i] =1;
        // }
        // for(int i = 0 ; i < m ; i++){
        //     dp[i][n-1] =1;
        // }
        // for(int i = m-2 ; i>=0 ; i--){
        //     for(int j = n-2 ; j>=0 ; j--){
        //         int down = dp[i+1][j];
        //         int right = dp[i][j+1];
        //         dp[i][j] =down+right;
        //     }
        // }
        // return dp[0][0];
    }
}