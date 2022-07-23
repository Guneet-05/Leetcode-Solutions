class Solution {
    
    public int memo(int[] cost,int idx,int[] dp) {
        
        if(idx == cost.length) return 0;
        
        if(dp[idx] != -1) return dp[idx];
        
        int ans1 = (idx + 1 <= cost.length) ? cost[idx] + memo(cost,idx + 1,dp) : Integer.MAX_VALUE;
        
        int ans2 = (idx + 2 <= cost.length) ? cost[idx] + memo(cost,idx + 2,dp) : Integer.MAX_VALUE;
        
        return dp[idx] = Math.min(ans1,ans2);
    }
    
    public int minCostClimbingStairs(int[] cost) {
        
        if(cost.length == 0 || cost == null) return 0;
        int[] dp1 = new int[cost.length + 1];
        Arrays.fill(dp1,-1);
        
        int ans1 = memo(cost,0,dp1);
        
        int[] dp2 = new int[cost.length + 1];
        Arrays.fill(dp2,-1);
        int ans2 = memo(cost,1,dp2);
        
        return Math.min(ans1,ans2);
    }
}