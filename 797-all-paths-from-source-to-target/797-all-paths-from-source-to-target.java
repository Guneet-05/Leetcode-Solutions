class Solution {
    List<List<Integer>> res;
    
    public void DFS(int src,int dest,int[][] graph,boolean[] vis,List<Integer> psf) {
        
        if(vis[src] == true) return;
        
        if(src == dest) {
            psf.add(dest);
            List<Integer> copy = new ArrayList<>(psf);
            res.add(copy);
            psf.remove(psf.size() -1);
            return;
        }
        
        vis[src] = true;
        psf.add(src);
        
        for(int nbr : graph[src]) {
            DFS(nbr,dest,graph,vis,psf);
        }
        
        vis[src] = false;
        psf.remove(psf.size() -1);
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> psf = new ArrayList<>();
        res = new ArrayList<>();
        boolean[] vis = new boolean[graph.length];
        
        DFS(0,graph.length-1,graph,vis,psf);
        return res;
    }
}