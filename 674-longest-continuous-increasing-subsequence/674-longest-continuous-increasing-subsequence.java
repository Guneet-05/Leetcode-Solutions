class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        int currLen = 1;
        
        for(int i=1;i<n;i++) {
            if(nums[i - 1] < nums[i]) {
                currLen++;
                maxLen = Math.max(currLen,maxLen);
            } else {
                currLen = 1;
            }
        }
        
        return maxLen;
    }
}