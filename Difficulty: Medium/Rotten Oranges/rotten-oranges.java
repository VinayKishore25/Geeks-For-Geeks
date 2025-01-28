//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find minimum time required to rot all oranges.
    public void print(Queue<int[]> q){
        while(!q.isEmpty()){
            System.out.println(Arrays.toString(q.poll()));
        }
    }
    public int orangesRotting(int[][] mat) {
        // Code here
        int n = mat.length;
        int m = mat[0].length;
        int fresh = 0;
        int time = 0;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                if(mat[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        // print(q);
        while(!q.isEmpty()){
            int x = q.size();
            time++;
            for(int p = 0 ; p < x ; p++){
                int[] node = q.poll();
                int i = node[0];
                int j = node[1];
                for(int k = 0 ; k < 4 ; k++){
                    int nr = i + directions[k][0];
                    int nc = j + directions[k][1];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] == 1){
                        fresh--;
                        q.add(new int[]{nr,nc});
                        mat[nr][nc] = 2;
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(mat) + " " + time);
        return fresh == 0 ? time - 1 : -1;
    }
}