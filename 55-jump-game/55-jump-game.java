class Solution {
    public boolean canJump(int[] nums) {
        
        if(nums.length > 1 && nums[0] == 0) return false;
        
        if(nums.length == 1) return true;
        
        int reach = 0;
        
        for(int i=0;i<nums.length -1;i++) {
            if(nums[i] == 0) {
                if(reach <= i) return false;
            }
            int curr = i + nums[i];
            reach = Math.max(curr,reach);
            if(reach >= nums.length -1) return true;
        }
        
        return false;
    }
}