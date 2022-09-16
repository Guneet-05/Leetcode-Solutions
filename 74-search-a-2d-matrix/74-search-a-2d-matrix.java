class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int lo = 0;
        int hi = rows * cols -1;
        
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            
            int rowIdx = mid / cols;
            int colIdx = mid % cols;
            
            if(matrix[rowIdx][colIdx] == target) return true;
            else if(matrix[rowIdx][colIdx] < target) lo = mid + 1;
            else hi = mid-1;
        }
        
        return false;
    }
}