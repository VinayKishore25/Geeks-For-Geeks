//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    int[][] dp = new int[101][101];
    public int solve(String str1,String str2,int i,int j)
    {
        if(i == str1.length())
        {
            return str2.length() - j;
        }
        if(j == str2.length())
        {
            return str1.length() - i;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
        if(str1.charAt(i) == str2.charAt(j))
        {
            return dp[i][j] = solve(str1,str2,i+1,j+1);
        }
        else
        {
            b = 1 + solve(str1,str2,i+1,j);
            c = 1 + solve(str1,str2,i+1,j+1);
            d = 1 + solve(str1,str2,i,j+1);
        }
        return dp[i][j] = Math.min(b,Math.min(c,d));
    }
    public int editDistance(String str1, String str2) {
        // Code here
        for(int[] dp1 : dp){
            Arrays.fill(dp1,-1);
        }
        int ans = solve(str1,str2,0,0);
        return ans;
    }
}