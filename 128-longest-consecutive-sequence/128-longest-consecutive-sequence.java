class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0) return 0;
        
        
        
        HashMap<Integer,Boolean> hm = new HashMap<>();
        
        for(int i=0;i<nums.length;i++) {
            hm.put(nums[i],true); //assuming nums[i] is the start of its series
        }
        
        for(int i=0;i<nums.length;i++) {
            int prev = nums[i] - 1;
            if(hm.containsKey(prev) == true) {
                hm.put(nums[i],false);
            }
        }
        
        int res = 1;
        
        for(int key : hm.keySet()) {
            if(hm.get(key) == true) {
                //this means that this key is the starting of a sequence
                int curr = 1;
                int next = key + 1;
                while(hm.containsKey(next) == true) {
                    curr++;
                    res = Math.max(res,curr);
                    next++;
                }
            }
        }
        
        return res;
    }
}