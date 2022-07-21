class Solution {
    
    public int fib(int n,int[] dp) {
        
        if(n == 0 || n == 1) return n;
        
        if(dp[n] != -1) return dp[n];
        
        int fibnm1 = fib(n-1);
        int fibnm2 = fib(n-2);
        
        return dp[n] = fibnm1 + fibnm2;
    }
    
    public int fib(int n) {
        
        if(n == 0 || n == 1) return n;
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        
        dp[0] = 0;
        dp[1] = 1;
        
        fib(n,dp);
        return dp[n];
    }
}