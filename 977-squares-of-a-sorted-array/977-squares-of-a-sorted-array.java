class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        int[] res = new int[nums.length];
        
        for(int idx=nums.length-1;idx>=0;idx--) {
            if(Math.abs(nums[right]) > Math.abs(nums[left])) {
                res[idx] = nums[right] * nums[right];
                right--;
            } else {
                res[idx] = nums[left] * nums[left];
                left++;
            }   
        }
        
        return res;
    }
}