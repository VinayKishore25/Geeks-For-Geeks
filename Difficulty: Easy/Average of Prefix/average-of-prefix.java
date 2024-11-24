//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Prints average of a stream of numbers
    public ArrayList<Integer> prefixAvg(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> prefix = new ArrayList<>();
        ArrayList<Integer> prefixAvg = new ArrayList<>();
        int n = arr.size();
        
        prefix.add(arr.get(0));
        prefixAvg.add(prefix.get(0)/1);
        for(int i = 1 ; i < n ; i++){
            prefix.add(prefix.get(i-1) + arr.get(i));
            prefixAvg.add(prefix.get(i)/(i+1));
        }
        return prefixAvg;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            String[] numbers = input.split(" ");
            for (String number : numbers) {
                arr.add(Integer.parseInt(number));
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.prefixAvg(arr);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends