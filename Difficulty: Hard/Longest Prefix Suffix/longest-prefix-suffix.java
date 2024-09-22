//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String str) {
        // code here
        int n=str.length();
        
        int prefix=0,suffix=1,pos=1,count=0;
        
        while(prefix<n && suffix<n){
            if(str.charAt(prefix)==str.charAt(suffix)){
                prefix++;
                suffix++;
                count++;
            }
            else{
                prefix=0; 
                pos++;
                suffix=pos;
                count=0;
            }
        }
        return count;
    }
}