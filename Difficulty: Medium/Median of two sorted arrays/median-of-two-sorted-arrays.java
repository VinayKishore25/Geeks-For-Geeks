//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int n = arr1.length;
        int m = arr2.length;
        int total = n+m;
        int mid1 = -1;
        int mid2 = -1;
        if(total%2 != 0){
            mid1 = total/2;
        }
        else{
            mid1 = total/2 - 1;
            mid2 = total/2;
        }
        // System.out.println(total + " " + mid1 + " " + mid2);
        int i = 0 , j = 0,count = -1;
        int ans = 0;
        while(i < n && j < m){
            if(arr1[i] > arr2[j])
            {
                count++;
                if(count == mid1){
                    // System.out.println(arr2[j] + " j1 " + j + " " + count);
                    ans+=arr2[j];
                }
                if(count == mid2 && mid2 != -1){
                    // System.out.println(arr2[j] + " j " + j);
                    ans += arr2[j];
                }
                j++;
            }
            else
            {
                count++;
                if(count == mid1){
                    // System.out.println(arr1[i] + " i " + i);
                    ans+=arr1[i];
                }
                if(count == mid2 && mid2 != -1){
                    // System.out.println(arr1[i] + " i " + i);
                    ans += arr1[i];
                }
                i++;
            }
        }
        while(i < n){
            count++;
            if(count == mid1){
                // System.out.println(arr1[i] + " i " + i);
                    ans+=arr1[i];
                }
                if(count == mid2 && mid2 != -1){
                    // System.out.println(arr1[i] + " i " + i);
                    ans += arr1[i];
                }
                i++;
            
        }
        while(j < m){
            count++;
            if(count == mid1){
                // System.out.println(arr2[j] + " j " + j);
                    ans+=arr2[j];
                }
                if(count == mid2 && mid2 != -1){
                    // System.out.println(arr2[j] + " j " + j);
                    ans += arr2[j];
                }
                j++;
        }
        return ans;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends