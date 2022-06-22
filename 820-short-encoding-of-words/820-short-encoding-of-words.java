class Solution {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> hs1 = new HashSet<>(Arrays.asList(words));
        HashSet<String> hs2 = new HashSet<>(Arrays.asList(words));
        
        for(String str : words) {
            for(int i=1;i<str.length();i++) {
                hs2.remove(str.substring(i));
            }
        }
        
        int res = 0;
        
        for(String str: hs2) {
            res += str.length() + 1;
        }
        
        return res;
    }
}