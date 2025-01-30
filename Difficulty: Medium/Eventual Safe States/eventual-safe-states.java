//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean dfs(List<List<Integer>> adj,int[] visited,int node){
        if(visited[node] == 1) return false;
        if(visited[node] == 2) return true;
        visited[node] = 1;
        for(int neighbour : adj.get(node)){
            // if(visited[neighbour] == 0){
            if(dfs(adj,visited,neighbour) == false){
                return false;
            // } 
            }
        }
        visited[node] = 2;
        return true;
    }
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        int[] visited = new int[V];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ;  i < V ; i++){
            // if(visited[i] == 0){
                if(dfs(adj,visited,i)){
                    ans.add(i);
                // }
            }
        }
        return ans;
    }
}
