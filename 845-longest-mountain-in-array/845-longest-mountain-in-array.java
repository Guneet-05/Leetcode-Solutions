class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        Arrays.fill(left,1);
        int currLen = 1;
        
        for(int i=1;i<n;i++) {
            if(arr[i] > arr[i-1]) {
                currLen++;
            } else {
                currLen = 1;
            }
            left[i] = currLen;
        }
        
        currLen = 1;
        
        int[] right = new int[n];
        Arrays.fill(right,1);
        
        for(int i=n-2;i>=0;i--) {
            if(arr[i] > arr[i + 1]) {
                currLen++;
            } else {
                currLen = 1;
            }
            right[i] = currLen;
        }
        
        int maxBitonic = 0;
        
        for(int i=0;i<n;i++) {
            int curr = left[i] + right[i] - 1;
            if(left[i] > 1 && right[i] > 1) {
                maxBitonic = Math.max(curr,maxBitonic);
            }
        }
        
        return maxBitonic;
    }
}