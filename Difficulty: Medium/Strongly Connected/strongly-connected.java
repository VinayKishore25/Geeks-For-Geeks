//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj,int node,Stack<Integer> st,boolean[] visited){
        visited[node] = true;
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                dfs(adj,neighbour,st,visited);
            }
        }
        st.push(node);
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int node,boolean[] visited){
        visited[node] = true;
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                dfs(adj,neighbour,visited);
            }
        }
    }
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Stack<Integer> st = new Stack<>();
        int n = adj.size();
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                dfs(adj,i,st,visited);
            }
        }
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adjT.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n ; i++){
            for(int neighbour : adj.get(i)){
                adjT.get(neighbour).add(i);
            }
        }
        visited = new boolean[n];
        int count = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            if(!visited[node]){
                count++;
            }
            for(int neighbour : adjT.get(node)){
                if(!visited[neighbour])
                dfs(adjT,neighbour,visited);
            }
        }
        return count;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            System.out.println(obj.kosaraju(adj));

            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends