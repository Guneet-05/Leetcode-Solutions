class Solution {
    
    static int INF = 1000001;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][target + 1][n + 1];
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<=target;j++) {
                for(int k=0;k<=n;k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        int ans = dfs(houses,cost,m,n,target,0,0,0,dp);
        return (ans < INF) ? ans : -1;
    }
    
    private int dfs(int[] houses,int[][] cost, int m, int n, int target, int i,int nbr,int left,int[][][] dp) {
        
        if(i == m) {
            return nbr == target ? 0 : INF;
        }
        
        if(nbr > target) {
            return INF;
        }
        
        if(dp[i][nbr][left] != -1) return dp[i][nbr][left];
        
        if(houses[i] == 0) {
            int minCost = INF;
            
            for(int c=1;c<=n;c++) {
               int newNbr = nbr;
                if(c != left) {
                    newNbr = nbr + 1;
                }
                
                minCost = Math.min(minCost,cost[i][c-1] + dfs(houses,cost,m,n,target,i+1,newNbr,c,dp));
            }
            
            dp[i][nbr][left] = minCost;
            
            return minCost;
        } else {
            int newNbr = nbr;
            if(houses[i] != left) {
                newNbr = nbr + 1;
            }
            return dp[i][nbr][left] = dfs(houses,cost,m,n,target,i+1,newNbr,houses[i],dp);
        }
    }
}