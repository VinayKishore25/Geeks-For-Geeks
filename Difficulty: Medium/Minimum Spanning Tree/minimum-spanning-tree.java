//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class DisjointSet{
    int n;
    int[] parent;
    int[] size;
    DisjointSet(int n){
        this.n = n;
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        size = new int[n];
        Arrays.fill(size,1);
    }
    int findParent(int node){
        if(parent[node] == node){
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }
    void union(int u,int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(size[pu] >= size[pv]){
            size[pu] += size[pv];
            parent[pv] = pu;
        }
        else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}
class Edge{
    int u;
    int v;
    int w;
    Edge(int u,int v,int w){
        this.u = u;
        this.v = v;
        this.w = w;
    }
}
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        List<Edge> edges = new ArrayList<>();
        DisjointSet ds = new DisjointSet(V);
        int n = adj.size();
        for(int i = 0 ; i < n ;i++){
            for(int[] edge : adj.get(i)){
                edges.add(new Edge(i,edge[0],edge[1]));
            }
        }
        n = edges.size();
        Collections.sort(edges,(a,b) -> (a.w - b.w));
        int twt = 0;
        for(int i = 0 ; i < n ; i++){
            int u = edges.get(i).u;
            int v = edges.get(i).v;
            int w = edges.get(i).w;
            if(ds.findParent(u) != ds.findParent(v)){
                twt += w;
                ds.union(u,v);
            }
        }
        return twt;
    }
}