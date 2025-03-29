//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n=profit.length;
        int[][] mat=new int[n][2];
        for(int i=0;i<deadline.length;i++){
            mat[i][0]=deadline[i];
            mat[i][1]=profit[i];
        }
        Arrays.sort(mat,(a,b)->b[1]-a[1]);
        
        int max_idx=-1;
        for(int dead_idx:deadline) max_idx=Math.max(max_idx,dead_idx);
        
        int[] task=new int[max_idx+1];
        int max_profit=0;
        int total_task=0;
        
        for(int i=0;i<n;i++){
            int idx=mat[i][0];
            while(idx!=0&&task[idx]!=0){
                idx--;
            }
            if(idx!=0){
                total_task++;
                task[idx]=mat[i][1];
                max_profit+=mat[i][1];
            }
        }    
        
        ArrayList<Integer> list=new ArrayList<>();
        list.add(total_task);
        list.add(max_profit);
        
        return list;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends