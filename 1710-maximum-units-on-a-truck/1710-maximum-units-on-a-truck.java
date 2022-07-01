class Solution {
    
    static class Pair implements Comparable<Pair>{
        int noOfBoxes;
        int noOfItemsPerUnitBox;
        
        Pair(int noOfBoxes,int noOfItemsPerUnitBox) {
            this.noOfBoxes = noOfBoxes;
            this.noOfItemsPerUnitBox = noOfItemsPerUnitBox;
        }
        
        public int compareTo(Pair other) {
            return other.noOfItemsPerUnitBox - this.noOfItemsPerUnitBox;
        }
    }
    
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;
        Pair[] arr = new Pair[n];
        
        for(int i=0;i<n;i++) {
            arr[i] = new Pair(boxTypes[i][0],boxTypes[i][1]);
        }
        
        Arrays.sort(arr);
        
        int res = 0;
        for(int i=0;i<arr.length;i++) {
            if(truckSize == 0) {
                break;
            } else {
                if(arr[i].noOfBoxes > truckSize) {
                    res += arr[i].noOfItemsPerUnitBox * (truckSize);
                    truckSize = 0;
                } else {
                    res += arr[i].noOfItemsPerUnitBox * (arr[i].noOfBoxes);
                    truckSize -= arr[i].noOfBoxes;
                }
            }   
        }
        
        return res;
    }
}