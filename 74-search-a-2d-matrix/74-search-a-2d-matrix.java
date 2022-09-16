class Solution {
    
    public boolean binSearch(int[][] matrix, int target, int i) {
        int lo = 0;
        int hi = matrix[0].length -1;
        
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            
            if(matrix[i][mid] == target) return true;
            else if(matrix[i][mid] < target) lo = mid + 1;
            else hi = mid -1;
        }
        
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int i=0;i<matrix.length;i++) {
            boolean val = binSearch(matrix,target,i);
            if(val == true) return true;
        }
        
        return false;
    }
}