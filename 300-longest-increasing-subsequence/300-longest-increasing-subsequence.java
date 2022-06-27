class Solution {
    
    public int memo(int[] nums, int idx, int prev,int[][] dp) {
        
        if(idx == nums.length) return 0;
        
        if(dp[idx][prev + 1] != -1) return dp[idx][prev + 1];
        
        int yes = (prev == -1 || nums[idx] > nums[prev]) ? memo(nums,idx + 1,idx,dp) + 1 : 0;
        
        int no =  memo(nums,idx + 1,prev,dp);
        
        return dp[idx][prev + 1] = Math.max(yes,no);
    }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLIS = 0;
        for(int i=0;i<n;i++) {
            dp[i] = 1;
            
            for(int j=0;j<i;j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            
            maxLIS = Math.max(maxLIS,dp[i]);
        }
        
        return maxLIS;
    }
}