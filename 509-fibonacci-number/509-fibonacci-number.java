class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        
        int prev0 = 0;
        int prev1 = 1;
        
        int res = 0;
        for(int i=2;i<=n;i++) {
            res = prev0 + prev1;
            prev0 = prev1;
            prev1 = res;
        }
        
        return res;
    }
}