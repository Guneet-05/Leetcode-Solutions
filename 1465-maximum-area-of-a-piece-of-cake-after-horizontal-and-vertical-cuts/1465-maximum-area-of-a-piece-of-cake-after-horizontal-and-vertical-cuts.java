class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long m = 1000000007;
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxHDiff = horizontalCuts[0];
        long maxVDiff = verticalCuts[0];
        
        for(int i=1;i<horizontalCuts.length;i++) {
            long diff = horizontalCuts[i] - horizontalCuts[i-1];
            maxHDiff = Math.max(maxHDiff,diff);
        }
        
        maxHDiff = Math.max(maxHDiff,h - horizontalCuts[horizontalCuts.length -1]);
        
        for(int i=1;i<verticalCuts.length;i++) {
            long diff = (verticalCuts[i] - verticalCuts[i-1]);
            maxVDiff = Math.max(maxVDiff,diff);
        }
        
        maxVDiff = Math.max(maxVDiff,w - verticalCuts[verticalCuts.length -1]);
        
        return (int) ((maxHDiff * maxVDiff) % m);
    }
}