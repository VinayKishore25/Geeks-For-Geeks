//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] cost = new int[n][m];
        for(int[] row : cost){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i,j});
                    cost[i][j] = 0;
                }
            }
        }
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] positions = q.poll();
            int i = positions[0];
            int j = positions[1];
            for(int k = 0; k < 4 ; k++){
                int nr = i + directions[k][0];
                int nc = j + directions[k][1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] != 1) {
                    if(cost[nr][nc] > cost[i][j] + 1){
                        cost[nr][nc] = cost[i][j] + 1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return cost;
    }
}