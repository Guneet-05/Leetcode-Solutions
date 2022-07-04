class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1) return 1;
        
        int res = 1;
        int flag = 0;
        
        if(nums[1] - nums[0] > 0) {
            flag = 1;
            res++;
        } else if(nums[1] - nums[0] < 0) {
            flag = -1;
            res++;
        }
        
        for(int i=2;i<nums.length;i++) {
            int diff = nums[i] - nums[i-1];
            
            if(diff < 0) {
                if(flag == -1) continue;
                res++;
                flag = -1;
            } else if(diff == 0) {
                continue;
            } else {
                if(flag == 1) continue;
                res++;
                flag = 1;
            }
        }
        
        return res;
    }
}