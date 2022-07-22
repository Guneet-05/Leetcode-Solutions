class Solution {
    
    public long memo(int[] nums, int idx,long[] dp) {
        if(idx == nums.length -1) return 0;
        
        if(dp[idx] != -1) return dp[idx];
        
        long min = Integer.MAX_VALUE;
        
        for(int i=1;i<=nums[idx];i++) {
            if(idx + i < nums.length) {
                min = Math.min(min,memo(nums,idx + i,dp));
            }
        }
        
        return dp[idx] = min + 1;
    }
    
    public int jump(int[] nums) {
        long[] dp = new long[nums.length + 1];
        Arrays.fill(dp,-1);
        return (int)memo(nums,0,dp);
    }
}