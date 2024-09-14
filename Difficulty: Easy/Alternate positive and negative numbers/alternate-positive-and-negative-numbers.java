//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int n = arr.size();
        for(int i = 0 ; i < n ; i++){
            if(arr.get(i) < 0){
                neg.add(arr.get(i));
            }
            else{
                pos.add(arr.get(i));
            }
        }
        int i = 0 , j = 0 , count = 0;
        while(count < n){
            if(i < pos.size()){
                arr.set(count,pos.get(i++));
                count++;
            }
            if(j < neg.size()){
                arr.set(count,neg.get(j++));
                count++;
            }
        }
    }
}