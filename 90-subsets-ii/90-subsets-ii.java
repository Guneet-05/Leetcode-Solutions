class Solution {
    
    List<List<Integer>> res;
    
    public void subsets(int[] nums, int idx,List<Integer> curr,boolean prev) {
        
        if(idx == nums.length) {
            List<Integer> copy = new ArrayList<>(curr);
            res.add(copy);
            return;
        }
        
        //no
        subsets(nums,idx + 1,curr,false);
        
        //yes
        
        if(idx > 0 && nums[idx] == nums[idx-1] && prev == false)
            return;
        
        curr.add(nums[idx]);
        subsets(nums,idx + 1,curr,true);
        curr.remove(curr.size()-1);
        
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums,0,new ArrayList<>(),false);
        return res;
    }
}