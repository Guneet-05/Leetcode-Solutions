// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    
    //-1 unvisited
    //0 -> same path visited i.e. preorder
    //1 -> other path visited i.e. postorder
    public boolean DFS(int src, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        
        //visited twice in same path
        if(vis[src] == 0) {
            return true;
        }
        
        //visited twice from another paths
        if(vis[src] == 1) {
            return false;
        }
        
        vis[src] = 0;
        
        for(int nbr : adj.get(src)) {
            if(DFS(nbr,adj,vis) == true) return true;
        }
        
        vis[src] = 1;
        
        return false;
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] vis = new int[V];
        Arrays.fill(vis,-1);
        
        for(int i=0;i<V;i++) {
            if(DFS(i,adj,vis) == true) return true;
        }
        
        return false;
    }
}