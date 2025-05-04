//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findSubString(String str) {
        // code here
         int n =  str.length();
        HashMap<Character,Integer>  map = new HashMap<>();
        int ans  =  n;
        int  k  = 0;
        int  arr[] = new int[26];
        for(int i  = 0 ; i  < n ;i++) {
            if(arr[str.charAt(i)-'a'] == 0 ) k++;
            arr[str.charAt(i)-'a']++;
        }
        for(int i  =  0; i< n;i++) {
            map.put(str.charAt(i) ,i);
            if(map.size()  ==  k ) ans  =  Math.min(ans ,   (Collections.max(map.values()) -  Collections.min(map.values())));
        }
        return ans+1;
    }
}