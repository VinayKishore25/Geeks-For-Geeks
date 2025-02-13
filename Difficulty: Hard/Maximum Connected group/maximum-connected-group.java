//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

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
            size[pu] += size[pv];
            parent[pv] = pu;
        }
        else{
            size[pv] += size[pu];
            parent[pu] = pv;
        }
    }
}
class Solution {

    public int MaxConnection(int grid[][]) {
        // Your code here
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0) continue;
                for(int k = 0 ; k < 4 ; k++){
                    int nr = i + directions[k][0];
                    int nc = j + directions[k][1];
                    if(nr >= 0 && nc >= 0 && nr < n && nc < n){
                        if(grid[nr][nc] == 1){
                            int currNode = i * n + j;
                            int adjNode = nr * n + nc;
                            if(ds.findParent(adjNode) != ds.findParent(currNode)){
                                ds.union(adjNode,currNode);
                            }
                        }
                    }
                }
            }
        }
        int maxSize = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1) continue;
                HashSet<Integer> parents = new HashSet<>();
                for(int k = 0 ; k < 4 ; k++){
                    int nr = i + directions[k][0];
                    int nc = j + directions[k][1];
                    if(nr >= 0 && nc >= 0 && nr < n && nc < n){
                        if(grid[nr][nc] == 1){
                            int adjNode = nr * n + nc;
                            parents.add(ds.findParent(adjNode));
                        }
                    }
                }
                int totalSize = 0;
                for(int node : parents){
                    totalSize += ds.size[node];
                }
                maxSize = Math.max(totalSize+1,maxSize);
            }
        }
        for(int i = 0 ; i < n * n ; i++){
            maxSize = Math.max(maxSize,ds.size[ds.findParent(i)]);
        }
        return maxSize;
    }
}