class Solution {
    
    int count;
    
    public void permutations(int n,int idx,boolean[] vis) {
        
        if(idx > n) {
            count++;
            return;
        }
        
        for(int i=1;i<=n;i++) {
            if(vis[i] == false && (i % idx == 0 || idx % i == 0)) {
                vis[i] = true;
                permutations(n,idx + 1,vis);
                vis[i] = false;
            }
        }
    }
    
    public int countArrangement(int n) {
        count = 0;
        permutations(n,1,new boolean[n+1]);
        return count;
    }
}