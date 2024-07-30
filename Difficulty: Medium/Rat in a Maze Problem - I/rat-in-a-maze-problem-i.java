//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public void drinker(int[][] mat, int i, int j,boolean[][] vis,ArrayList<String> al,int n,StringBuilder sb)
    {
        if(i< 0 || j < 0 || i >= n || j >= n || vis[i][j] || mat[i][j] == 0) return;
        if(i == n-1 && j == n-1 && mat[i][j] == 1){
            al.add(sb.toString());
            return;
        }
        vis[i][j] = true;
        sb.append("D");
        drinker(mat,i+1,j,vis,al,n,sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("U");
        drinker(mat,i-1,j,vis,al,n,sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("R");
        drinker(mat,i,j+1,vis,al,n,sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("L");
        drinker(mat,i,j-1,vis,al,n,sb);
        sb.deleteCharAt(sb.length() - 1);
        vis[i][j] = false;
        
    }
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> al = new ArrayList<>();
        int n = mat.length;
        if(mat[0][0] == 0 || mat[n-1][n-1]==0){
            al.add("-1");
            return al;
        }
        boolean[][] vis = new boolean[n][n];
        drinker(mat,0,0,vis,al,n,new StringBuilder());
        if(al.isEmpty()){
            al.add("-1");
            return al;
        }
        else
        return al;
    }
}