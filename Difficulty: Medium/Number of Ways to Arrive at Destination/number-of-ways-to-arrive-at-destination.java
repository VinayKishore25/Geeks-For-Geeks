//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        
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

    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        int mod = 10000_00007;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> road : roads){
            adj.get(road.get(0)).add(new Pair(road.get(1),road.get(2)));
            adj.get(road.get(1)).add(new Pair(road.get(0),road.get(2)));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.second - b.second);
        long[] distance = new long[n];
        int[] ways = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair root = pq.poll();
            int node = root.first;
            int dist = root.second;
            for(Pair pair : adj.get(node)){
                int neighbour = pair.first;
                int weight = pair.second;
                if(dist + weight < distance[neighbour]){
                    distance[neighbour] = (dist+weight)%mod;
                    pq.offer(new Pair(neighbour,(dist+weight)%mod));
                    ways[neighbour] = ways[node];
                }
                else if(dist + weight == distance[neighbour]){
                    ways[neighbour] = (ways[neighbour] + ways[node])%mod;
                }
                
            }
        }
        return ways[n-1];
    }
}
