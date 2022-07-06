class Solution {
    
    public void DFS(int[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0 || grid[r][c] == -1) return;
        
        grid[r][c] = -1;
        
        DFS(grid,r -1,c);
        DFS(grid,r,c + 1);
        DFS(grid,r + 1,c);
        DFS(grid,r,c -1);
    }
    
    public int numEnclaves(int[][] grid) {
       
        int rows = grid.length;
        int cols = grid[0].length;
        
        int landCount = 0;
        
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == 1) landCount++;
            }
        }
        
        int ans = 0;
        //for 0th row
        for(int j=0;j<cols;j++) {
            if(grid[0][j] == 1) {
                DFS(grid,0,j);
            }
        }
        
        //for last col
        for(int i=0;i<rows;i++) {
            if(grid[i][cols -1] == 1) {
                DFS(grid,i,cols-1);
            }
        }
        
        //for last row
        for(int j=cols-1;j>=0;j--) {
            if(grid[rows-1][j] == 1) {
                DFS(grid,rows-1,j);
            }
        }
        
        //for first column
        for(int i=rows-1;i>=0;i--) {
            if(grid[i][0] == 1) {
                DFS(grid,i,0);
            }
        }
        
        int visCount = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == -1) visCount++;
            }
        }
        
        return landCount - visCount;
    }
}