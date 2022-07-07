class Solution {
    
    static class Edge {
        int src;
        int nbr;
        
        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            graph[u].add(new Edge(u,v));
            graph[v].add(new Edge(v,u));
        }
        
        boolean[] vis = new boolean[n];
        return BFS(source,destination,graph);
    }
    
    public boolean BFS(int src, int dest,ArrayList<Edge>[] graph) {
        Queue<Integer> q = new ArrayDeque<>();
        int n = graph.length;
        boolean[] vis = new boolean[n];
        
        q.add(src);
        
        while(q.size() > 0) {
            int front = q.remove();
            
            if(vis[front] == true) continue;
            if(front == dest) return true;
            vis[front] = true;
            
            for(Edge e : graph[front]) {
                if(vis[e.nbr] == false) {
                    q.add(e.nbr);
                }
            }
        }
        
        return false;
    }
    
    public boolean DFS(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        
        if(src == dest) return true;
        
        vis[src] = true;
        
        for(Edge e : graph[src]) {
            if(vis[e.nbr] == false) {
                boolean hasNbrPath = DFS(graph,e.nbr,dest,vis);
                if(hasNbrPath == true) return true;
            }
        }
        
        return false;
    }
}