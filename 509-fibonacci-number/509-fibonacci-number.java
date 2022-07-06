class Solution {
    public int fib(int n) {
       
       if(n <= 1) return n; 
        
        int a = 0;
        int b = 1;
        int res = 0;
        for(int i=2;i<=n;i++) {
            int c = a + b;
            res = c;
            a = b;
            b = c;
        }
        
        return res;
    }
}