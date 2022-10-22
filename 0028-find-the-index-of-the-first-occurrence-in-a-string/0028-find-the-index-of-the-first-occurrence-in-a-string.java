class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        
        for(int i=0;i<=haystack.length() - needle.length();i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int count = 1;
                int j = i + 1;
                int k = 1;
                while(count < n) {
                    if(haystack.charAt(j) != needle.charAt(k)) break;
                    j++;
                    k++;
                    count++;
                }
                if(count == n) return i;
            }
        }
        
        return -1;
    }
}