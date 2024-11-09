//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String minSum(int[] arr) {
        // code hereddffggggh
        Arrays.sort(arr);
        // int n1 = 0, n2 = 0;
        int n = arr.length;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < arr.length; i += 2) {
            sb1.append(arr[i]);
            if (i + 1 < arr.length) {
                sb2.append(arr[i + 1]);
            }
        }

        int i = sb1.length() - 1;
        int j = sb2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = i >= 0 ? sb1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? sb2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10; 
            i--;
            j--;
        }
        result = result.reverse();
        while(result.length() > 0 && result.charAt(0) == '0'){
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}
