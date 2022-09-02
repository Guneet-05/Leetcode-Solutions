class Solution {
    
    public int numberOfDigits(int x) {
        int nod = 0;
        
        while(x > 0) {
            nod++;
            x /= 10;
        }
        
        return nod;
    }
    
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        
        int temp = x;
        int p = (int)Math.pow(10,numberOfDigits(x)-1);
        int ans = 0;
        
        while(temp > 0) {
            int d = temp % 10;
            temp /= 10;
            ans += d*p;
            p /= 10;
        }
        
        if(ans == x) return true;
        return false;
    }
}