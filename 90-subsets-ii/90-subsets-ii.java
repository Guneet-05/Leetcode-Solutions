class Solution {
    
    List<List<Integer>> ans;
    
    public void subsets(int[] nums,int idx,List<Integer> curr,boolean prev) {
        
        if(idx == nums.length) {
            //deep copy
            List<Integer> copy = new ArrayList<>(curr);
            ans.add(copy);
            return;
        }
        
        //no
        subsets(nums,idx + 1,curr,false);
        
        if(idx > 0 && nums[idx] == nums[idx-1] && prev  == false)
            return;
        
        //yes
        curr.add(nums[idx]);
        subsets(nums,idx + 1,curr,true);
        curr.remove(curr.size() -1); //backtracking
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums,0,new ArrayList<>(),false);
        return ans;  
    }
}