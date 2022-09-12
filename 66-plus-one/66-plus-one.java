class Solution {
    public int[] plusOne(int[] digits) {
        int ca = 0;
        int[] b = {1};
        int n = (digits.length > b.length) ? digits.length + 1 : b.length + 1;
        int[] res = new int[n];
        int i = digits.length-1;
        int j = b.length-1;
        int k = n-1;
        
        while(i >=0 || j>=0 || ca > 0) {
            int d1 = (i >= 0) ? digits[i] : 0;
            int d2 = (j >= 0) ? b[j] : 0;
            
            int digit = 0;
            if(d1 + d2 + ca >= 10) {
                digit = (d1 + d2 + ca) % 10;
                ca = (d1 + d2 + ca)/10;
            } else {
                digit = d1 + d2 + ca;
                ca = 0;
            }
            
            res[k] = digit;
            k--;
            i--;
            j--;
        }
        
        if(res[0] != 0) return res;
        int[] ans = new int[res.length-1];
        
        for(int lv=1;lv<res.length;lv++) {
            ans[lv-1] = res[lv];
        }
        
        return ans;
    }
}