class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        
        while(i < s.length()) {
            int j = i+1;
            
            while(j < s.length() && s.charAt(j) != ' ') {
                j++;
            } 
            
            for(int x=j-1;x>=i;x--) {
                sb.append(s.charAt(x));
            }
            
            i = j + 1;
            if(i < s.length()) sb.append(' ');
        }
        
        return sb.toString();
    }
}