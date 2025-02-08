//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
          //code here
          int[][] adjMatrix = new int[n][n];
          for(int[] row : adjMatrix)
          Arrays.fill(row,Integer.MAX_VALUE);
          for(int[] edge: edges){
            adjMatrix[edge[0]][edge[1]] = edge[2];
            adjMatrix[edge[1]][edge[0]] = edge[2];
          }
          for(int i = 0 ; i < n ; i++){
              adjMatrix[i][i] = 0;
          }
          for(int k = 0 ; k < n ; k++){
              for(int i = 0 ; i < n ; i++){
                  for(int j = 0 ; j < n ; j++){
                      if(adjMatrix[i][k] == Integer.MAX_VALUE || adjMatrix[k][j] == Integer.MAX_VALUE){
                          continue;
                      }
                      else{
                          adjMatrix[i][j] = Math.min(adjMatrix[i][j],adjMatrix[i][k]+adjMatrix[k][j]);
                      }
                  }
              }
          }
          int maxCount = Integer.MAX_VALUE , maxCity = 0;
          for(int i = 0 ; i < n ; i++){
              int count = 0;
              for(int j = 0 ; j < n ; j++){
                  if(adjMatrix[i][j] <= distanceThreshold){
                      count++;
                  }
              }
              if(count <= maxCount){
                  maxCount = count;
                  maxCity = i;
              }
          }
          return maxCity;
      }
}
