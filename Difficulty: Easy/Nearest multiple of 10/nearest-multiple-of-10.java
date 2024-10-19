//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    String roundToNearest(String str) {
        // Complete the function
        Stack<Character> st=new Stack<>();
       int len=str.length();
       int i=len-1;
       int flag=0,temp=0;
       while(i>=0){
           if(i==len-1 && (str.charAt(i)-'0')>5){
               if(i==0){
                st.push('0');
                st.push('1');
               }else{
                st.push('0');   
               }
               i--;
               flag=1;
           }else{
               if(flag==1 && (str.charAt(i)-'0')==9){
                   if(i==0){
                       st.push('0');
                       st.push('1');
                   }else{
                    st.push('0');
                   }
                    i--;
               }else if(flag==1 && (int)str.charAt(i)!=9){
                   int num=(int)str.charAt(i);
                   num++;
                   char ch=(char)num;
                   st.push(ch);
                   i--;
                   flag=0;
                   temp++;
               }
               else{
                   if(temp==0 && str.charAt(i)-'0'<=5){
                    st.push('0');   
                    temp++;
                   }else{
                       st.push(str.charAt(i));
                   }
                   i--;
               }
           }
      }
      String ans="";
     while(st.size()!=0){
          ans+=String.valueOf(st.pop());
      }
      return ans;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends