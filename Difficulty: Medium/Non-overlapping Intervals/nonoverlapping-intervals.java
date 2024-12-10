//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRemoval(int inter[][]) {
        // code here
        Arrays.sort(inter,(a,b)->b[0]-a[0] );
        int count=0;
        int []arr=inter[0];
        for(int i=1;i<inter.length;i++)
        {
           if(arr[0]>=inter[i][1])
           {
               arr=inter[i];
           }
           else
           {
                count++;   
           }
        }
        return count;
    }
}
