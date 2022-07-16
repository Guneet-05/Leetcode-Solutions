class Solution {
    int m = 1000000007;
    public long solve(int sr,int sc, int m, int n,int curr, int max,Long[][][] dp) {
        
        if(curr < max && (sr < 0 || sc < 0 || sr >= m || sc >= n)) return 1L;
        
        if(curr == max) {
            if(sr < 0 || sc < 0 || sr >= m || sc >= n) return 1L;
            return 0L;
        }
        
        if(dp[sr][sc][curr] != null) return dp[sr][sc][curr];
        
        long ans1 = solve(sr,sc + 1,m,n,curr + 1,max,dp);
        long ans2 = solve(sr + 1,sc,m,n,curr + 1,max,dp);
        long ans3 = solve(sr,sc - 1,m,n,curr + 1,max,dp);
        long ans4 = solve(sr - 1,sc,m,n,curr + 1,max,dp);
        
        return dp[sr][sc][curr] =  (ans1 + ans2 + ans3 + ans4) % 1000000007;
    }
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        Long[][][] dp = new Long[m + 1][n + 1][maxMove + 1];
        
        
       return (int)solve(startRow,startColumn,m,n,0,maxMove,dp);
    }
}