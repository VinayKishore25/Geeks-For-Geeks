//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public void printAdj(ArrayList<ArrayList<int[]>> adj,int V){
        for (int i = 0; i < V; i++) {
            System.out.print("Node " + i + ": ");
            for (int[] pair : adj.get(i)) {
                System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
            }
            System.out.println();
        }
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        int[] distance = new int[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            int currDist = distance[node];
            for(int[] pair : adj.get(node)){
                int neighbour = pair[0];
                int weight = pair[1];
                if(currDist + weight < distance[neighbour]){
                    distance[neighbour] = currDist + weight;
                    q.add(neighbour);
                }
            }
        }
        for(int i = 0 ; i < V ; i++){
            if(distance[i] == Integer.MAX_VALUE){
                distance[i] = -1;
            }
        }
        return distance;
    }
}