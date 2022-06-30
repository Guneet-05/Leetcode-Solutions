class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        //this is an element vs index hashMap
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++) {
            int comp = target - nums[i];
            if(hm.containsKey(comp) == true) {
                res[0] = hm.get(comp);
                res[1] = i;
                break;
            } else {
                hm.put(nums[i],i);
            }
        }
        
        return res;
    }
}