class Solution {
    
    public void reverse(int[] arr, int lo, int hi) {
         while(lo < hi) {
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            lo++;
            hi--;
        }
    }
    
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int n = nums.length;
        
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,0,n-1);
    }
}