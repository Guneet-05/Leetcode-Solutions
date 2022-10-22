class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] suffix = new int[nums.length];
        int[] prefix = new int[nums.length];
        
        suffix[suffix.length -1] = nums[nums.length -1];
        for(int i=suffix.length-2;i>=0;i--) {
            suffix[i] = nums[i] * suffix[i + 1];
        }
        
        prefix[0] = nums[0];
        for(int i=1;i<prefix.length;i++) {
            prefix[i] = nums[i] * prefix[i - 1];
        }
        
        int[] res = new int[nums.length];
        for(int i=0;i<res.length;i++) {
            int prev = (i - 1 >= 0) ? prefix[i-1] : 1;
            int next = (i + 1 < res.length) ? suffix[i + 1] : 1;
            res[i] = prev * next; 
        }
        
        return res;
    }
}