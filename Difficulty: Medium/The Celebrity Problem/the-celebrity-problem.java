//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        HashSet<Integer> celebrity = new HashSet<>();
        HashMap<Integer,Integer> hm= new HashMap<>();
        if(n == 1) return 0;
        for(int i = 0 ; i < n ; i++)
        {
            int count = 0;
            for(int j = 0 ; j < m ; j++)
            {
                if(mat[i][j] == 0)
                {
                    count++;
                }
                if(mat[i][j] == 1)
                {
                    hm.put(j,hm.getOrDefault(j,0)+1);
                }
            }
            if(count == m)
            {
                celebrity.add(i);
            }
        }
        for(int each : celebrity)
        {
            if(hm.containsKey(each) && hm.get(each) == n - 1)
            {
                return each;
            }
        } 
        return -1;
        
    }
}