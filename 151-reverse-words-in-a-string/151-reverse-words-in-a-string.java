class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder("");
        
        int i = s.length()-1;
        
        while(i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        while(i >= 0) {
            int j = i-1;
            
            while(j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            
            for(int x=j+1;x<=i;x++) {
                char ch = s.charAt(x);
                sb.append(ch);
            }
            
            while(j >= 0 && s.charAt(j) == ' ') {
                j--;
            }
            
            i = j;
            if(i >= 0) sb.append(' ');
        }
        
        return sb.toString();
    }
}