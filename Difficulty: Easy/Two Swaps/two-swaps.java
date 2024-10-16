//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Read number of test cases

        // Loop through each test case
        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            List<Integer> arr = new ArrayList<>();

            // Convert input to list of integers
            for (String str : inputArr) {
                arr.add(Integer.parseInt(str));
            }

            Solution ob = new Solution();
            boolean ans = ob.checkSorted(arr);

            // Output result
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }

        scanner.close();
    }
}

// } Driver Code Ends


class Solution {

    public boolean checkSorted(List<Integer> arr) {
        // code here
        boolean isSorted = true;

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                isSorted = false;
                break;
            }
        }
        
        if(isSorted) return true;
        int swap=0;
         for(int i=0;i<arr.size()-1;i++){
              int min=i;
              for(int j=i+1;j<arr.size();j++){
                   if(arr.get(j) < arr.get(min)){
                        min=j;
                   }
              }
             if (min != i) {
                Collections.swap(arr, i, min);
                swap++;
            }
            
             if (swap > 2) {
                return false;
            }
               
         }
         
        
         
          return swap==2;
    }
}