//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int n = arr.length;
        int count = 0;
        for(int i = 0 ; i < n - 2 ; i++){
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == target){
                    count++;
                    int tp1 = j+1;
                    int tp2 = k-1;
                    while (tp1 < k && arr[tp1] == arr[j]){ 
                        count++;
                        tp1++;
                    }
                    while (tp2 > j && arr[tp2] == arr[k]){ 
                        count++;
                        tp2--;
                    }
                    j++;
                    k--;
                }
                else if(sum < target){
                    j++;
                }
                else{
                    k--;   
                }
            }
        }
        return count;
    }
}