class Solution {
    
    public List<List<Integer>> subsets(int[] nums, int idx) {
        
        if(idx == nums.length) {
            List<List<Integer>> res =  new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        
        List<List<Integer>> smallAns = subsets(nums,idx + 1);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(List<Integer> list : smallAns) {
            List<Integer> subset = new ArrayList<>();
            
            subset.add(nums[idx]);
            
            for(int x : list) {
                subset.add(x);
            }
            
            ans.add(list);
            ans.add(subset);
        }
        
        return ans;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums,0);
    }
}