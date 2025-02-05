//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Triplet{
    int first;
    int second;
    int third;
    Triplet(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            adj.get(flight[0]).add(new Pair(flight[1],flight[2])); 
        }
        Queue<Triplet> q = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        q.add(new Triplet(src,0,0));
        distance[src] = 0;
        while(!q.isEmpty()){
            Triplet triplet = q.poll();
            int node = triplet.first;
            int steps = triplet.second;
            int dist = triplet.third;
            if(steps > k) continue;
            for(Pair pair : adj.get(node)){
                int neighbour = pair.first;
                int weight = pair.second;
                if(weight + dist < distance[neighbour] && steps <= k){
                    distance[neighbour] = weight + dist;
                    q.add(new Triplet(neighbour,steps+1,distance[neighbour]));
                }
            }
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}