//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        // Your code here
        int max = 100000;
        if(start == end) return 0;
        int[] distance = new int[max];
        int n = arr.length;
        Queue<Pair> q = new LinkedList<>();
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start] = 0;
        q.add(new Pair(start,0));
        while(!q.isEmpty()){
            Pair node = q.poll();
            int num = node.first;
            int steps = node.second;
            for(int i = 0 ; i < n ; i++){
                int newVal = (num * arr[i])%max;
                if(newVal == end) return steps + 1;
                if(distance[newVal] > steps + 1){
                    distance[newVal] = steps + 1;
                    q.offer(new Pair(newVal,steps+1));
                }
            }
        }
        return -1;
    }
}
