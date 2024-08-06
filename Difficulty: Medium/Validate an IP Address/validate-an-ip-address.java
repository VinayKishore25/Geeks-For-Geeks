//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Write your code here
        String[] arr = str.split("\\.");
        // System.out.println(Arrays.toString(arr));
        if(arr.length > 4 || arr.length < 4) return false;
        for(int i = 0 ; i < 4 ; i++)
        {
            if(arr[i].equals("")) return false;
            int n = arr[i].length();
            for(int j = 0 ; j < n ; j++)
            {
                if(arr[i].charAt(j) == '0' && j == 0 && n > 1) return false;
                if(arr[i].charAt(j) >= '0' && arr[i].charAt(j) <= '9'){
                    continue;
                }
                else{
                    return false;
                }
            }
            int value = Integer.parseInt(arr[i]);
            if(value < 0 || value > 255) return false;
        }
        return true;
    }
}