// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    int[] topo;
    int idx;
    
    void DFS(int src, ArrayList<ArrayList<Integer>> adj,boolean[] vis) {
        if(vis[src] == true) return;
        
        vis[src] = true;
        
        
        for(int nbr : adj.get(src)) {
            DFS(nbr,adj,vis);
        }
        
        topo[idx--] = src;
    }
    
    public void DFS2(ArrayList<ArrayList<Integer>> adj,int src,boolean[] vis) {
        if(vis[src] == true) return;
        
        vis[src] = true;
        
        for(int nbr : adj.get(src)) {
            DFS2(adj,nbr,vis);
        }
    }
    
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int n, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        topo = new int[n];
        idx = n-1;
        boolean[] vis = new boolean[n];
        
        for(int i=0;i<n;i++) {
            DFS(i,adj,vis);
        }
        
        int potentialAns = topo[0];
        boolean[] vis2 = new boolean[n];
        DFS2(adj,potentialAns,vis2);
        
        for(int i=0;i<vis2.length;i++) {
            if(vis2[i] == false) return -1;
        }
        
        return potentialAns;
    }
}