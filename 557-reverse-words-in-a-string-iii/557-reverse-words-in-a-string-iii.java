class Solution {
    public String reverseWords(String s) {
       StringBuilder sb = new StringBuilder("");
       int i = 0;
        
        while(i < s.length()) {
            int j = i+1;
            
            while(j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            
            for(int k=j-1;k>=i;k--) {
                sb.append(s.charAt(k));
            }
            
            i = j + 1;
            if(i < s.length()) sb.append(' ');
        }
        
        return sb.toString();
    }
}