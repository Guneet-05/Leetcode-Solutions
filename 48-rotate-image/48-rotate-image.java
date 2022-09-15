class Solution {
    
    public void transpose(int[][] mat) {
        for(int i=0;i<mat.length;i++) {
            for(int j=i;j<mat[0].length;j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
    
    public void reverseRow(int[][] mat, int i) {
        int lo = 0;
        int hi = mat[0].length-1;
        
        while(lo < hi) {
            int temp = mat[i][lo];
            mat[i][lo] = mat[i][hi];
            mat[i][hi] = temp;
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