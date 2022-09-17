class Solution {
    
    public boolean binSearch(int[][] matrix,int i,int target) {
        int lo = 0;
        int hi = matrix[0].length -1;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            if(matrix[i][mid] == target) return true;
            else if(matrix[i][mid] < target) lo = mid + 1;
            else hi = mid -1;
        }
        
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int i=0;i<matrix.length;i++) {
            if(target >= matrix[i][0] && target <= matrix[i][matrix[0].length-1]) {
                boolean val = binSearch(matrix,i,target);
                if(val == true) return true;
            }
        }
        
        return false;
    }
}