class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        
        for(int i=n-1;i>=0;i--) {
            int maxIdx = i;
            for(int j=i-1;j>=0;j--) maxIdx = (arr[j] > arr[maxIdx]) ? j : maxIdx;
            
            if(maxIdx != i) {
                reverse(arr,0,maxIdx);
                res.add(maxIdx+1);
                reverse(arr,0,i);
                res.add(i+1);
            }
        }
        
        return res;
    }
    
    public void reverse(int[] arr, int lo, int hi) {
        while(lo < hi) {
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            lo++;
            hi--;
        }
    }
}