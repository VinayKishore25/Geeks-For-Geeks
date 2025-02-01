//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    static public boolean dfs(char[][] mat,boolean[][] visited,String word,int curr,int i,int j,int n,int m,int len){
        if(i < 0 || j < 0 || i >= n || j >= m || visited[i][j] ){
            return false;
        }
        if(curr == len){
            return true;
        }
        visited[i][j] = true;
        boolean hasWord = false;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int k = 0 ; k < 4 ; k++){
            int nr = i + directions[k][0];
            int nc = j + directions[k][1];
            if(nr>= 0 && nc >= 0 && nr < n && nc < m && mat[nr][nc] == word.charAt(curr)){
                hasWord |= dfs(mat,visited,word,curr+1,nr,nc,n,m,len);
            }
        }
        visited[i][j] = false;
        return hasWord;
        
    }
    static public boolean isWordExist(char[][] mat, String word) {
        // Code here
        int n = mat.length;
        int m = mat[0].length;
        int len = word.length();
        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(word.charAt(0) == mat[i][j] && dfs(mat,visited,word,1,i,j,n,m,len)){
                    return true;
                }
            }
        }
        return false;
    }
}