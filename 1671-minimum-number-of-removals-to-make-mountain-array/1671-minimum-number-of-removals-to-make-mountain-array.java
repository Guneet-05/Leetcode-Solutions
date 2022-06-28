class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        for(int i=0;i<n;i++) {
            left[i] = 1;
            for(int j=0;j<i;j++) {
                if(nums[j] < nums[i]) {
                    left[i] = Math.max(left[i],left[j] + 1);
                }
            }
        }
        
        for(int i=n-1;i>=0;i--) {
            right[i] = 1;
            
            for(int j=n-1;j>i;j--) {
                if(nums[j] < nums[i]) {
                    right[i] = Math.max(right[i],right[j] + 1);
                }
            }
        }
        
        int maxBitonic = 0;
        
        for(int i=0;i<n;i++) {
            int currLen = left[i] + right[i] - 1;
            if(left[i] > 1 && right[i] > 1) {
                maxBitonic = Math.max(maxBitonic,currLen);
            }
        }
        
        return n - maxBitonic;
    }
}