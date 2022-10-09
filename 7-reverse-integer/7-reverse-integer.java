class Solution {

    public int reverse(int x) {
        if(x == 0) return 0;
        
        boolean isNeg = false;
        if(x < 0) {
            isNeg = true;
            x = -x; //make x positive
        }
        
        int rev = 0;
        
        while(x > 0) {
            
            int d = x % 10;
            x /= 10;
            
            if(rev > Integer.MAX_VALUE/10 || rev < Integer.MIN_VALUE/10) return 0;
            
            rev = rev * 10 + d;
        }
        
        if(isNeg) return -rev;
        return rev;
    }
}