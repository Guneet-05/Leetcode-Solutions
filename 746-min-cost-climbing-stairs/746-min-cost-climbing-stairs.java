class Solution {
    
    public int solve(int[] cost,int idx,int[] dp) {
        
        if(idx >= cost.length) return 0;
        
        if(dp[idx] != -1) return dp[idx];
        
        int ans1 = cost[idx] + solve(cost,idx + 1,dp);
        int ans2 = cost[idx] + solve(cost,idx + 2,dp);
        
        return dp[idx] = (int)Math.min(ans1,ans2);
    }
    
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp,-1);
        int ans1 = solve(cost,0,dp);
        int ans2 = solve(cost,1,dp);
        return (int)Math.min(ans1,ans2);
    }
}