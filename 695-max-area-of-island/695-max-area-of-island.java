class Solution {
    
    public void DFS(int[][] grid, int r, int c,int[] count) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1)
            return;
        
        grid[r][c] = -1; //mark visited
        count[0]  = count[0] + 1;
        
        DFS(grid,r - 1,c,count);
        DFS(grid,r,c + 1,count);
        DFS(grid,r + 1,c,count);
        DFS(grid,r,c - 1,count);
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int max = 0;
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    int[] curr = new int[1];
                    DFS(grid,i,j,curr);
                    max = Math.max(max,curr[0]);
                }
            }
        }
        
        return max;
    }
}