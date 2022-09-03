class Solution {
    
    public int reverse(int x) {
        int res = 0;
        
        while(x != 0) {
            int digit = x % 10;
            x /= 10;
            
            
            res  = (res * 10) + digit;
            
        }
        
        return res;
    }
    
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        
        int reverse = reverse(x);
        if(reverse == x) return true;
        return false;
    }
}