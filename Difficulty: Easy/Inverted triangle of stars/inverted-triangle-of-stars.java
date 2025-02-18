//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            String[] S = ob.invIsoTriangle(N);
            
            for(int i=0; i<S.length; i++)
                System.out.println(S[i]);
        }
    }
}
// } Driver Code Ends



class Solution {
    static String[] invIsoTriangle(int N) {
        // code here
        String[] res = new String[N];
        
        for(int i = 0 ; i < N ; i++){
            String temp = "";
            for(int j = 0 ; j < i ; j++){
                temp+=" ";
            }
            for(int j = 0 ; j < 2 * (N - i) - 1 ; j++){
                temp+="*";
            }
            for(int j = 0 ; j < i ; j++){
                temp+=" ";
            }
            res[i] = temp;
        }
        return res;
    }
};