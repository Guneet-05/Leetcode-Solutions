class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return new int[0];
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean up = true;
        
        int r = 0, c = 0;
        int[] arr = new int[n*m];
        int i = 0;
        while(r < m && c < n) {
            if(up) {
                while(r > 0 && c < n-1) {
                    arr[i++] = matrix[r][c];
                    r--;
                    c++;
                }
                arr[i++] = matrix[r][c];
                if(c == n-1) {
                    r++;
                } else {
                    c++;                    
                }
            } else {
                while(r < m-1 && c > 0) {
                    arr[i++] = matrix[r][c];
                    r++;
                    c--;
                }
                arr[i++] = matrix[r][c];
                if(r == m-1) {
                    c++;
                } else {
                    r++;
                }
            }
            up = !up;
        }
        
        return arr;
    }
}