//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java
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
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }
    void union(int u,int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(size[pu] >= size[pv]){
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        DisjointSet ds = new DisjointSet(V);
        int k = 0;
        for(int i = 0 ; i < V ; i++){
            for(int j = 0 ; j < V ; j++){
                if(adj.get(i).get(j) == 1){
                    ds.union(i,j);
                }
            }
        }
        int count = 0;
        // System.out.println(Arrays.toString(ds.parent));
        for(int i = 0 ; i < V ; i++){
            if(ds.parent[i] == i){
                count++;
            }
        }
        return count;
    }
};