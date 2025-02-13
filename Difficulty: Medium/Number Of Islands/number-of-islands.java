//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


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
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        List<Integer> noOfIslands = new ArrayList<>();
        DisjointSet ds = new DisjointSet(rows*cols);
        boolean[][] vis = new boolean[rows][cols];
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int count = 0;
        for(int[] point : operators){
            int row = point[0];
            int col = point[1];
            if(vis[row][col]){
                noOfIslands.add(count);
                continue;
            }
            vis[row][col] = true;
            count++;
            for(int k = 0 ; k < 4 ; k++){
                int nr = row + directions[k][0];
                int nc = col + directions[k][1];
                if(nr >= 0 && nc >= 0 && nr < rows && nc < cols){
                    if(vis[nr][nc]){
                        int currNode = row * cols + col;
                        int adjNode = nr * cols + nc;
                        if(ds.findParent(adjNode) != ds.findParent(currNode)){
                            ds.union(adjNode,currNode);
                            count--;
                        }
                    }
                }
            }
            noOfIslands.add(count);
        }
        return noOfIslands;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends