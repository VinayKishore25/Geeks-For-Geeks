//{ Driver Code Starts
// Initial Template for Java
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
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution
{
    //Function to return Breadth First Traversal of given graph.
    int timer = 1;
    public void dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,int[] time,int[] low,boolean[] visited,int[] mark){
        visited[node] = true;
        time[node] = low[node] = timer++;
        int child = 0;
        for(int neighbour : adj.get(node)){
            if(neighbour == parent) continue;
            if(!visited[neighbour]){
                dfs(neighbour,node,adj,time,low,visited,mark);
                low[node] = Math.min(low[node],low[neighbour]);
                if(low[neighbour] >= time[node] && parent != -1){
                    mark[node] = 1;
                }
                child++;
            }
            else{
                low[node] = Math.min(low[node],time[neighbour]);
            }
        }
        if(child > 1 && parent == -1){
            mark[node] = 1;
        }
    }
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        
        boolean[] visited = new boolean[V];
        int[] time = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V];
        ArrayList<Integer> articulation = new ArrayList<>();
        dfs(0,-1,adj,time,low,visited,mark);
        for(int i = 0 ; i < V ; i++){
            if(mark[i] == 1){
                articulation.add(i);
            }
        }
        if(articulation.size() == 0){
            return new ArrayList<>(Arrays.asList(-1));
        }
        return articulation;
    }
}