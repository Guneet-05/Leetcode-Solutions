class Solution {
    int count;
    public void solve(int n,int idx,boolean[] vis) {
        if(idx > n) count++;
        for(int i=1;i<=n;i++) {
            if(vis[i] == false && (idx % i == 0 || i%idx == 0)) {
                vis[i] = true;
                solve(n,idx + 1,vis);
                vis[i] = false;
            }
        }
    }
    
    public int countArrangement(int n) {
        count = 0;
        boolean[] vis = new boolean[n+1];
        solve(n,1,vis);
        return count;
    }
}