class Solution {
    
    public int lowerBound(ArrayList<Integer> nums, int target) {
        int lo = 0;
        int hi = nums.size() -1;
        
        int pa = nums.size();
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            if(nums.get(mid) == target) {
                return mid;
            } else if(nums.get(mid) < target) {
                lo = mid + 1;        
            } else {
                pa = mid;
                hi = mid -1;
            }
        }
        
        return pa; 
    }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        ArrayList<Integer> sorted = new ArrayList<>();
        
        for(int i=0;i<n;i++) {
            int lb = lowerBound(sorted,nums[i]);
            if(lb == sorted.size()) {
                sorted.add(nums[i]);
            } else {
                sorted.set(lb,nums[i]);
            }
        }
        
        return sorted.size();
    }
}