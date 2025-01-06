//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        Arrays.sort(arr);
        List<Integer> al = new ArrayList<>();
        int n = arr.length;
        int i = 0 , j = n - 1;
        int p1 = -1 , p2 = -1;
        int diff = Integer.MAX_VALUE;
        while(i < j){
            int sum = arr[i] + arr[j];
            if(sum == target){
                p1 = arr[i];
                p2 = arr[j];
                break;
            }
            else if(sum < target){
                if((Math.abs(sum - target) < diff)){
                    p1 = arr[i];
                    p2 = arr[j];
                    diff = Math.abs(sum - target);
                }
                else if( Math.abs(sum - target) == diff && Math.abs(p1 - p2) < Math.abs(arr[i] - arr[j])){
                    p1 = arr[i];
                    p2 = arr[j];
                    diff = Math.abs(sum - target);
                }
                i++;
            }
            else{
                if((Math.abs(sum - target) < diff) ||(Math.abs(sum - target) == diff && Math.abs(p1 - p2) < Math.abs(arr[i] - arr[j]))){
                    p1 = arr[i];
                    p2 = arr[j];
                    diff = Math.abs(sum - target);
                }
                j--;
            }
        }
        if(p1 != -1 && p2 != -1){
            al.add(p1);
            al.add(p2);
        }
        return al;
        
    }
}