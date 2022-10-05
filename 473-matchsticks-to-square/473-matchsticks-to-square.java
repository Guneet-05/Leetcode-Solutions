class Solution {
    
    public void reverse(int[] arr) {
        int lo = 0;
        int hi = arr.length-1;
        
        while(lo < hi) {
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            lo++;
            hi--;
        }
        
    }
    
    public boolean dfs(int[] matchsticks,int[] sides,int idx,int sideLength) {
        
        if(idx == matchsticks.length) return true;
        
        for(int i=0;i<4;i++) {
            if(sides[i] + matchsticks[idx] <= sideLength) {
                sides[i] += matchsticks[idx];
                if(dfs(matchsticks,sides,idx + 1,sideLength) == true)
                    return true;
                sides[i] -= matchsticks[idx];
            }
        }
        
        return false;
    }
    
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length == 0 || matchsticks == null) return false;
        
        int p = 0;
        
        for(int val : matchsticks) p += val;
        if(p % 4 != 0) return false;
        
        int sideLength = p/4;
        int[] sides = new int[4];
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        
        return dfs(matchsticks,sides,0,sideLength);
    }
}