class Solution {
    
    public int subtractProductAndSum(int n) {
        // if(n == 0) return 0;
        
        int sum = 0;
        int product = 1;
        
        while(n > 0) {
            int d = n % 10;
            n /= 10;
            sum += d;
            product *= d;
        }
        
        return (product - sum);
    }
}