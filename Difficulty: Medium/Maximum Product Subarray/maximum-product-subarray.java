//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends




class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr) {
        // code here
        long i = 1 , j = 1 ; 
        int n = arr.length;
        long max = Integer.MIN_VALUE;
        for(int k = 0 ; k < n ; k++)
        {
            if(i==0)
            i=1;
            if(j==0)
            j=1;
            i*=arr[k];
            j*=arr[n-k-1];
            max = Math.max(max,Math.max(i,j));
        }
        return max;
    }
}