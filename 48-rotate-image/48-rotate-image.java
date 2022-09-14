class Solution {
    
    public void transpose(int[][] arr) {
        
        for(int i=0;i<arr.length;i++) {
            for(int j=i;j<arr.length;j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
    
    public void reverseRow(int[][] matrix, int i) {
        int lo = 0;
        int hi = matrix[0].length -1;
        
        while(lo < hi) {
            int temp = matrix[i][lo];
            matrix[i][lo] = matrix[i][hi];
            matrix[i][hi] = temp;
            lo++;
            hi--;
        }
    }
    
    public void rotate(int[][] matrix) {
        transpose(matrix);
        
        for(int i=0;i<matrix.length;i++) {
            reverseRow(matrix,i);
        }
    }
}