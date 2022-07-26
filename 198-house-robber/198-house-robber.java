class Solution {
    
    public int memo(int[] nums, int idx,int prev,int[][] dp) {
        
        if(idx == nums.length) return 0;
        
        if(dp[idx][prev] != -1) return dp[idx][prev];
        
        int yes = (prev == 0) ? memo(nums,idx + 1,1,dp) + nums[idx] : 0;
        int no = memo(nums,idx + 1,0,dp);
        
        return dp[idx][prev] = Math.max(yes,no);
    }
    
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        
        for(int i=0;i<=nums.length;i++) {
            for(int j=0;j<2;j++) {
                dp[i][j] = -1;
            }
        }
        
        return memo(nums,0,0,dp);
    }
}