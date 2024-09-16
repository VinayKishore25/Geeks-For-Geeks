//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String s){
        // code here
        int res = 0;
        int n = s.length();
        int[] check = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }
            else{
                if(!st.isEmpty()){
                    // res = Math.max(res,i - st.peek() + 1);
                    check[st.peek()] = 1;
                    check[i] = 1;
                    st.pop();
                }
            }
        }
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(check[i] == 1){
                count++;
                res = Math.max(res,count);
            }
            else{
                count = 0;
            }
        }
        return res;
    }
}