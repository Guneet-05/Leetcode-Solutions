class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        int i = 0;
        
        while(i < chars.length) {
            int j = i;
            
            while(j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            
            chars[idx++] = chars[i];
            
            if(j - i > 1) {
                String count = "" + (j-i);
                for(int x=0;x<count.length();x++) {
                    char ch = count.charAt(x);
                    chars[idx++] = ch;
                }
            }
            
            i = j;
        }
        
        return idx;
    }
}