//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0;
        solve(arr,ans,sum,0,n);
        return ans;
    }
    public void solve(ArrayList<Integer> arr,ArrayList<Integer> ans,int sum,int i ,int n){
        if(i == n){
            ans.add(sum);
            return;
        }
        sum+=arr.get(i);
        solve(arr,ans,sum,i+1,n);
        sum-=arr.get(i);
        solve(arr,ans,sum,i+1,n);
    }
}