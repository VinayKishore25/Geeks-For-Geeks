//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int s) 
    {
        // Your code here
        ArrayList<Integer> al = new ArrayList<>();
        int n = arr.length;
        int i = 0 , j = 0 , sum = 0;
        while(j < n)
        {
            sum += arr[j];
            while(sum > s && i < j)
            {
                if(sum == s)
                {
                    al.add(i+1);
                    al.add(j+1);
                    break;
                }
                sum-=arr[i];
                i++;
            }
            if(sum == s)
                {
                    al.add(i+1);
                    al.add(j+1);
                    break;
                }
            j++;
            if(al.size() == 2) break;
        }
        if(al.size() == 2) return al;
        else al.add(-1);
        return al;
    }
}