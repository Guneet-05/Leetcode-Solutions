class Solution {
    
    public void DFS(int src,int dest,int[][] graph,boolean[] vis,List<Integer> psf,List<List<Integer>> res) {
       
        if(vis[src] == true) return;
        
        vis[src] = true;
        psf.add(src);
        
        if(src == dest) {
            res.add(new ArrayList<>(psf));
        } 
        
        for(int nbr : graph[src]) {
            DFS(nbr,dest,graph,vis,psf,res);
        }
        
        
        vis[src] = false;
        psf.remove(psf.size() - 1);
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> psf = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[graph.length];
        
        DFS(0,graph.length-1,graph,vis,psf,res);
        return res;
    }
}