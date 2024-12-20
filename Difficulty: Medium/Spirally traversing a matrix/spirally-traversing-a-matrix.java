//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int rs = 0, re = n - 1, cs = 0 , ce = m -1 ;
        int total = 0;
        while(al.size() < n * m){
            for(int i = cs; i <= ce ; i++)
            {
                al.add(matrix[rs][i]);
            }
            rs++;
            for(int i = rs ; i <= re ; i++)
            {
                al.add(matrix[i][ce]);
            }
            ce--;
            for(int i = ce ; i >= cs; i--)
            {
                al.add(matrix[re][i]);
            }
            re--;
            for(int i = re ; i >= rs ; i--)
            {
                al.add(matrix[i][cs]);
            }
            cs++;
        }
        while(al.size() > n*m){
            al.remove(al.size() - 1);
        }
        return al;
    }
}
