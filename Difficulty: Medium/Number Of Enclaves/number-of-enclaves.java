//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        
out.println("~");
}
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void connectLand(int[][] grid,boolean[][] vis,int i,int j){
        int n = grid.length;
        int m = grid[0].length;
        if(i < 0 || j < 0 || i>= n || j >= m || vis[i][j] || grid[i][j] == 0){
            return;
        }
        vis[i][j] = true;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int k = 0 ; k < 4 ; k++){
            connectLand(grid,vis,i+directions[k][0],j + directions[k][1]);
        }
        
    }
    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int j = 0 ; j < m ; j++){
            if(grid[0][j] == 1 && !vis[0][j]){
                connectLand(grid,vis,0,j);
            }
            if(grid[n-1][j] == 1 && !vis[n-1][j]){
                connectLand(grid,vis,n-1,j);
            }

        }
        for(int i = 0 ; i < n ; i++){
            if(grid[i][0] == 1 && !vis[i][0]){
                connectLand(grid,vis,i,0);
            }
            if(grid[i][m-1] == 1 && !vis[i][m-1]){
                connectLand(grid,vis,i,m-1);
            }
        }
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}