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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if(grid[destination[0]][destination[1]] == 0 || grid[source[0]][source[1]] == 0){
            return -1;
        } 
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] distance = new int[n][m];
        for(int[] row : distance){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        distance[source[0]][source[1]] = 0;
        q.add(new int[]{source[0],source[1],0});
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] root = q.poll();
            int i = root[0];
            int j = root[1];
            int cost = root[2];
            if(i == destination[0] && j == destination[1]){
                return cost;
            }
            for(int k = 0 ; k < 4 ; k++){
                int nr = i + directions[k][0];
                int nc = j + directions[k][1];
                if(nr >= 0 && nc >=0 && nr < n && nc < m && grid[nr][nc] == 1 && cost + 1 < distance[nr][nc]){
                    distance[nr][nc] = cost + 1;
                    
                    q.add(new int[]{nr,nc,cost+1});
                }
            }
        }
        return -1;
    }
}
