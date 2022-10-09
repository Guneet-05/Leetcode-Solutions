class Solution {
    
    public int reverse(int x) {
         int rev = 0;
        
        while(x > 0) {
            
            int d = x % 10;
            x /= 10;
            rev = rev * 10 + d;
        }
        
        return rev;
    }
    
    public boolean isSameAfterReversals(int num) {
        int rev1 = reverse(num);
        int rev2 = reverse(rev1);
        if(rev2 == num) return true;
        return false;
    }
}