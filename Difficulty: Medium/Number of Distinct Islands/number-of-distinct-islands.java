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
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    HashSet<String> hs = new HashSet<>();
    void dfs(int[][] grid,boolean[][] visited,int i,int j,StringBuilder sb,int originI,int originJ){
        int n = grid.length;
        int m = grid[0].length;
        if(i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        sb.append((i-originI)+"-"+(j - originJ)+"/");
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int k = 0 ; k < 4 ; k++){
            dfs(grid,visited,i + directions[k][0],j+directions[k][1],sb,originI,originJ);
        }
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int island = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid,visited,i,j,sb,i,j);
                    hs.add(sb.toString());
                }
            }
        }
        return hs.size();
    }
}
