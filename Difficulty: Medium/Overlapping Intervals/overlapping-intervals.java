//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        List<int[]>res = new ArrayList<int[]>();
        HashMap<Integer, Integer>map = new HashMap<>();
        ArrayList<Integer>list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            int max = Integer.MIN_VALUE;
            if(map.containsKey(arr[i][0]))max = map.get(arr[i][0]);
            map.put(arr[i][0], Math.max(max,arr[i][1]));
            list.add(arr[i][0]);
        }
        Collections.sort(list);
        int x = list.get(0);
        int y = map.get(x);
        
        for(int i=1; i<list.size(); i++){
            int num = list.get(i);
            if(num>y){
                int[]add = {x, y};
                res.add(add);
                x = num;
                y = map.get(x);
            }else if(map.get(num)>y){
                y = map.get(num);
            }
        }
        int[]add = {x, y};
        if(!res.contains(add))
            res.add(add);
        return res;
    }
}