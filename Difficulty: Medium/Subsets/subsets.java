//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Using a Set to remove duplicates
            Set<Integer> uniqueElements = new LinkedHashSet<>();
            for (String token : tokens) {
                uniqueElements.add(Integer.parseInt(token));
            }

            // Converting the set to an array
            int[] arr = new int[uniqueElements.size()];
            int idx = 0;
            for (int num : uniqueElements) {
                arr[idx++] = num;
            }

            // Finding and printing subsets
            ArrayList<ArrayList<Integer>> res = new Solution().subsets(arr);
            for (ArrayList<Integer> subset : res) {
                for (int num : subset) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // code here
        int n = arr.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        solve(arr,ans,temp,0,n);
        Collections.sort(ans , (l1,l2) -> {
            int n1 = l1.size();
            int m = l2.size();
            for(int i = 0 ; i < Math.min(n1,m) ; i++){
                int dif = Integer.compare(l1.get(i),l2.get(i));
                if(dif != 0){
                    return dif;
                }
            }
            return Integer.compare(n1,m);
        });
        return ans;
    }
    public void solve(int[] arr,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> temp,int i ,int n){
        if(i == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[i]);
        solve(arr,ans,temp,i+1,n);
        temp.remove(temp.size() - 1);
        solve(arr,ans,temp,i+1,n);
    }
}