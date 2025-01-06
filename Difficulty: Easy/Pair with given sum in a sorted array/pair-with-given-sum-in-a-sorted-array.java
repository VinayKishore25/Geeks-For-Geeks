//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int n = arr.length;
        int i = 0 , j =  n - 1;
        int count = 0;
        while(i < j){
            int sum = arr[i] + arr[j];
            if(sum == target){
                int tp1 = i + 1;
                int tp2 = j - 1;
                count++;
                while( tp1 < j && arr[i] == arr[tp1]){
                    count++;
                    tp1++;
                }
                while(tp2 > i && arr[j] == arr[tp2]){
                    count++;
                    tp2--;
                }
                i++;
                j--;
            }
            else if(sum < target){
                i++;
            }
            else{
                j--;
            }
        }
        return count;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends