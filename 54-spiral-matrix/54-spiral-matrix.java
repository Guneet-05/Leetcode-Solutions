class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int fr = 0, fc = 0, lr = matrix.length-1, lc = matrix[0].length-1;
        
        int count = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        
        while(count != n * m) {
            
            //first row
            for(int j=fc;j<=lc;j++) {
                list.add(matrix[fr][j]);
                count++;
            }
            fr++;
            
            if(count == n * m) break;
            
            //last col
            for(int i=fr;i<=lr;i++) {
                list.add(matrix[i][lc]);
                count++;
            }
            lc--;
            
            if(count == n*m) break;
            
            //last row
            for(int j=lc;j>=fc;j--) {
                list.add(matrix[lr][j]);
                count++;
            }
            lr--;
            
            if(count == n*m) break;
            
            //first col
            for(int i=lr;i>=fr;i--) {
                list.add(matrix[i][fc]);
                count++;
            }
            fc++;
            
            if(count == n*m) break;
        }
        
        return list;
    }
}