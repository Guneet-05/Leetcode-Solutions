class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int fr = 0, fc = 0, lr = m-1, lc = n-1;
        
        while(count != m*n) {
            
            //first row
            for(int j=fc;j<=lc;j++) {
                list.add(matrix[fr][j]);
                count++;
            }
            
            fr++;
            
            if(count == m*n) break;
            
            //last col
            for(int i=fr;i<=lr;i++) {
                list.add(matrix[i][lc]);
                count++;
            }
            lc--;
            
            if(count == m*n) break;
            
            //last row
            for(int j=lc;j>=fc;j--) {
                list.add(matrix[lr][j]);
                count++;
            }
            lr--;
            
            if(count == m*n) break;
            
            //first col
            for(int i=lr;i>=fr;i--) {
                list.add(matrix[i][fc]);
                count++;
            }
            fc++;
            
            if(count == m*n) break;
        }
        
        return list;
    }
}