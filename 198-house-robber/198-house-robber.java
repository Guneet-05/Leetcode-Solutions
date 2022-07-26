class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        
        int[][] dp = new int[2][nums.length];
        
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        
        for(int j=1;j<nums.length;j++) {
            dp[0][j] = Math.max(dp[0][j-1],dp[1][j-1]);
            dp[1][j] = nums[j] + dp[0][j-1];
        }
        
        return Math.max(dp[0][nums.length-1],dp[1][nums.length-1]);
    }
}