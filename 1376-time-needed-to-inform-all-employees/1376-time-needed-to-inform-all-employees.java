class Pair {
    int nbr;
    int wt;
    
    Pair(int nbr, int wt) {
        this.nbr = nbr;
        this.wt = wt;
    }
}

class Graph {
    ArrayList<Pair>[] adj;
    
    Graph(int n) {
        adj = new ArrayList[n];
        for(int i=0;i<n;i++) {
            adj[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int src, int nbr,int wt) {
//         Directed and Weighted
        adj[src].add(new Pair(nbr,wt));
    }
}

class Solution {
    
    public int DFS(int src,int time,Graph g) {
        int maxTime = time;
        for(Pair p : g.adj[src]) {
            maxTime = Math.max(maxTime,DFS(p.nbr,time + p.wt,g));
        }
        
        return maxTime;
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Graph g = new Graph(n);
        int time = 0;
        
        for(int i=0;i<n;i++) {
            //i-> child and array[i] is parent
            if(manager[i] == -1) {
                time = informTime[i];
            } else {
                g.addEdge(manager[i],i,informTime[i]);
            }
        }
        
        return DFS(headID,time,g);
    }
}