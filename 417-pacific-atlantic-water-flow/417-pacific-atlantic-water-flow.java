class Solution {
    
    public void DFS(int[][] heights,int r, int c,boolean[][] vis) {
        if(r < 0 || c < 0 || r >= vis.length || c >= vis[0].length || vis[r][c] == true) return;
        
        vis[r][c] = true;
        //r -1
        if(r - 1 >= 0 && heights[r-1][c] >= heights[r][c]) {
            DFS(heights,r -1,c,vis);
        }
        //c + 1
        if(c + 1 < heights[0].length && heights[r][c + 1] >= heights[r][c]) {
            DFS(heights,r,c + 1,vis);
        }
        //r + 1
        if(r + 1 < heights.length && heights[r+1][c] >= heights[r][c]) {
            DFS(heights,r + 1,c,vis);
        }
        
        //c -1
        if(c - 1 >= 0 && heights[r][c - 1] >= heights[r][c]) {
            DFS(heights,r,c - 1,vis);
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] visPacific = new boolean[heights.length][heights[0].length];
        
        for(int j=0;j<heights[0].length;j++) {
            DFS(heights,0,j,visPacific);
        }
        
        for(int i=0;i<heights.length;i++) {
            DFS(heights,i,0,visPacific);
        }
        
        boolean[][] visAtlantic = new boolean[heights.length][heights[0].length];
        
        for(int j=0;j<heights[0].length;j++) {
            DFS(heights,heights.length-1,j,visAtlantic);
        }
        
        for(int i=0;i<heights.length;i++) {
            DFS(heights,i,heights[0].length-1,visAtlantic);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<heights.length;i++) {
            for(int j=0;j<heights[0].length;j++) {
                if(visPacific[i][j] == true && visAtlantic[i][j] == true) {
                    List<Integer> index = new ArrayList<>();
                    index.add(i);index.add(j);
                    res.add(index);
                }
            }
        }
        
        return res;
    }
}