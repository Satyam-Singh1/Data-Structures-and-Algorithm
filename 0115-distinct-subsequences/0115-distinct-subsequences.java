class Solution {
    public int solve(int n, int m, String s, String t,int [][]dp) {
        if (m == t.length())
            return 1;
        if (n == s.length())
            return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        int cnt = 0;
        //pick
        if (s.charAt(n) == t.charAt(m)) {
            cnt += solve(n + 1, m + 1, s, t,dp);
        }
        cnt += solve(n+1, m, s, t,dp);
        return dp[n][m] = cnt;
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int [][]dp = new int[n][m];
        for(int []x:dp){
            Arrays.fill(x,-1);
        }
        return solve(0, 0, s, t,dp);
    }
}