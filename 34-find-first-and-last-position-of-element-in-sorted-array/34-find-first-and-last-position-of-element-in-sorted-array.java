class Solution {
    
    public int firstIndex(int[] nums,int target) {
        int lo = 0;
        int hi = nums.length -1;
        
        int pa = -1;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            if(nums[mid] == target) {
                pa = mid;
                hi = mid -1;
            } else if(nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return pa;
    }
    
    public int lastIndex(int[] nums,int target) {
        int lo = 0;
        int hi = nums.length -1;
        
        int pa = -1;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            if(nums[mid] == target) {
                pa = mid;
                lo = mid + 1;
            } else if(nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return pa;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = firstIndex(nums,target);
        res[1] = lastIndex(nums,target);
        
        return res;
    }
}