//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        String ans = arr[0];
        int n = arr.length;
        for(int i = 1 ; i < n ; i++)
        {
            int l = arr[i].length();
            int m = ans.length();
            String res = "";
            for(int j =0 ; j < Math.min(l,m) ; j++)
            {
                if(arr[i].charAt(j) == ans.charAt(j))
                {
                    res += ans.charAt(j);
                }
                else{
                    break;
                }
            }
            if(res.equals("")){
                ans = res;
                break;
            }
            else{
                ans = res;
            }
        }
        if(ans.equals("")) return "-1";
        else return ans;
    }
}