//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int[][] board = new int[n][n];
        ChessBoard(al,board,0,n,temp);
        return al;
    }
    public void ChessBoard(ArrayList<ArrayList<Integer>> al,int[][] board,int col, int n,ArrayList<Integer> temp){
        if(col == n){
            al.add(new ArrayList<>(temp));
            return;
        }
        for(int row = 0 ; row < n ; row++){
            if(Safety(board,row,col)){
                board[row][col] = 1;
                temp.add(row+1);
                ChessBoard(al,board,col+1,n,temp);
                board[row][col] = 0;
                temp.remove(temp.size() - 1);
            }
        }
    }
    public boolean Safety(int[][] b,int row, int col){
        int i=row,j=col;
        while(j>=0) {
            if(b[i][j--]==1){
                return false;
            }
        }
        i=row;j=col;
        while(i>=0 && j>=0){
            if(b[i--][j--]==1)
            {
                return false;
            }
        } 
        i=row;j=col;
        while(i<b.length && j>=0) {
            if(b[i++][j--]==1){
                return false;
            } 
        }
        return true;
    }
}