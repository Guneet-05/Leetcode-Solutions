class Solution {
    public boolean isPowerOfTwo(int n) {
        
        for(int i=0;i<=30;i++) {
            int power = (int)Math.pow(2,i);
            if(power == n) return true;
        }
        
        return false;
    }
}