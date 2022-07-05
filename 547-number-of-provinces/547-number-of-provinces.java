class Solution {
    
    class Graph {
        public ArrayList<Integer>[] adj;

        Graph(int n) {
            adj = new ArrayList[n];
            for(int i=0;i<n;i++) {
                adj[i] = new ArrayList<>();
            }

        }

        public void addEdge(int src, int dest) {
            adj[src].add(dest);
            adj[dest].add(src);
        }
   }

    
    public static void DFS(int src,Graph g,boolean[] vis, List<Integer> comp) {
        if(vis[src] == true) return;
        
        vis[src] = true;
        comp.add(src);
        
        for(int nbr : g.adj[src]) {
            DFS(nbr,g,vis,comp);
        }
    }
    
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        Graph g = new Graph(n);
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i != j && isConnected[i][j] == 1) {
                    g.addEdge(i,j);
                }
            }
        }
        
        boolean[] vis = new boolean[n];
        List<List<Integer>> comps = new ArrayList<>();
        
        for(int i=0;i<n;i++) {
            if(vis[i] == false) {
                List<Integer> comp = new ArrayList<>();
                DFS(i,g,vis,comp);
                comps.add(comp);
            }
        }
        
        return comps.size();   
    }
}