class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> {return b[1] - a[1];});
        
        int n = boxTypes.length;
        int res = 0;
        
        for(int i=0;i<n;i++) {
            if(truckSize == 0) {
                break;
            } else {
                if(boxTypes[i][0] > truckSize) {
                    res += boxTypes[i][1] * truckSize;
                    truckSize = 0;
                } else {
                    res += boxTypes[i][1] * boxTypes[i][0];
                    truckSize -= boxTypes[i][0];
                }
            }
        }
        
        return res;
    }
}