//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        int[] res = new int[2];
        long a = 0 ;
        int n = arr.length;
        boolean[] vis = new boolean[n+1];
        long sum = (n*(n+1))/2;
        for(int i = 0 ; i < n ; i++){
            if(vis[arr[i]] == true){
                res[0] = arr[i];
            }
            vis[arr[i]] = true;
        }
        for(int i = 1 ;i <= n ; i++){
            if(!vis[i]){
                res[1] = i;
            }
        }
        if(res[1] == 0) res[1] = n;
        return res;
    }
}