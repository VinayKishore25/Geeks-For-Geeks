//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int m = Integer.parseInt(in.readLine());
            char mat[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                String S[] = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = S[j].charAt(0);
                }
            }

            Solution ob = new Solution();
            char[][] ans = ob.fill(mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static void getBorders(char[][] mat,boolean[][] visited,int i,int j, int n , int m){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        visited[i][j] = true;
        while(!q.isEmpty()){
            int[] root = q.poll();
            int curI = root[0];
            int curJ = root[1];
            for(int k = 0 ; k < 4 ; k++){
                int nr = curI + directions[k][0];
                int nc = curJ + directions[k][1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]){
                    if(mat[nr][nc] == 'O'){
                        q.add(new int[]{nr,nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }
    static char[][] fill(char mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            if(!visited[i][0] && mat[i][0] == 'O'){
                getBorders(mat,visited,i,0,n,m);
                
            }
            if(!visited[i][m-1] && mat[i][m-1] == 'O'){
                getBorders(mat,visited,i,m-1,n,m);
                
            }
        }
        for(int j = 0 ; j < m ; j++){
            if(!visited[0][j] && (mat[0][j] == 'O')){
                getBorders(mat,visited,0,j,n,m);
            }
            if(!visited[n-1][j] && (mat[n-1][j] == 'O')){
                getBorders(mat,visited,n-1,j,n,m);
            }
        }
        char[][] res = new char[n][m];
        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j]){
                    res[i][j] = 'X';
                }
                else{
                    res[i][j] = 'O';
                }
            }
        }
        return res;
    }
}