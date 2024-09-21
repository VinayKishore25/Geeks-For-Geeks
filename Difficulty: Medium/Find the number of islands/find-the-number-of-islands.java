//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to find the number of islands.
    void solve(int i,int j,boolean[][] vis,char[][] grid,int n,int m){
        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] == '0') return;
        vis[i][j] = true;
        solve(i+1,j,vis,grid,n,m);
        solve(i-1,j,vis,grid,n,m);
        solve(i,j+1,vis,grid,n,m);
        solve(i,j-1,vis,grid,n,m);
        solve(i+1,j+1,vis,grid,n,m);
        solve(i-1,j+1,vis,grid,n,m);
        solve(i+1,j-1,vis,grid,n,m);
        solve(i-1,j-1,vis,grid,n,m);
        
    }
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && grid[i][j] != '0'){
                    count++;
                    solve(i,j,vis,grid,n,m);
                }
            }
        }
        return count;
    }
}