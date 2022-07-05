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

class Solution {
    
    public static void DFS(int src,Graph g,boolean[] vis, List<Integer> comp) {
        if(vis[src] == true) return;
        
        vis[src] = true;
        comp.add(src);
        
        for(int nbr : g.adj[src]) {
            DFS(nbr,g,vis,comp);
        }
    }
    
    public long countPairs(int n, int[][] edges) {
        Graph g = new Graph(n);
        for(int[] edge : edges) {
            g.addEdge(edge[0],edge[1]);
        }
        
        boolean[] vis = new boolean[n];
        List<List<Integer>> comps = new ArrayList<>();
        
        long pairs = 0;
        for(int i=0;i<n;i++) {
            if(vis[i] == false) {
                List<Integer> comp = new ArrayList<>();
                DFS(i,g,vis,comp);
                pairs = pairs + ((comp.size()) * ((n * 1l) - comp.size()));
            }
        }
        
        return pairs/2l;
        
    }
}