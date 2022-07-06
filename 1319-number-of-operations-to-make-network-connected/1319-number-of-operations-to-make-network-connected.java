class Graph {
    ArrayList<Integer>[] adj;
    
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
    
    public void DFS(Graph g, int src, boolean[] vis,List<Integer> comp) {
        if(vis[src] == true) return;
        
        vis[src] = true;
        comp.add(src);
        
        for(int nbr : g.adj[src]) {
            DFS(g,nbr,vis,comp);
        }
    }
    
    public int countComps(Graph g) {
        int n = g.adj.length;
        
        boolean[] vis = new boolean[n];
        List<List<Integer>> comps = new ArrayList<>();
        int count = 0;
        for(int i=0;i<n;i++) {
            if(vis[i] == false) {
                List<Integer> comp = new ArrayList<>();
                DFS(g,i,vis,comp);
                comps.add(comp);
            }
        }
        
        System.out.println(comps);
        return comps.size();
    }
    
    public int makeConnected(int n, int[][] connections) {
        Graph g = new Graph(n);
        
        if(connections.length < n-1) return -1;
        
        for(int[] edge : connections) {
            g.addEdge(edge[0],edge[1]);
        }
        
        int cmps = countComps(g);
        return cmps -1;
    }
}