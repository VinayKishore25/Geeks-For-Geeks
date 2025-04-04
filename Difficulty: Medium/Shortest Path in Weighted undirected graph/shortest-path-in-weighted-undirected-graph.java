//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);

            ot.println(list.get(0));
            if (list.get(0) != -1 && !check(list, edges)) ot.println(-1);
        }
        ot.close();
    }

    static boolean check(List<Integer> list, int edges[][]) {
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 1; i < list.size(); i++) hs.add(list.get(i));
        for (int x[] : edges) {
            if (hs.contains(x[0]) || hs.contains(x[1])) {
                if (!hm.containsKey(x[0])) hm.put(x[0], new HashMap<>());
                if (!hm.containsKey(x[1])) hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (!hm.containsKey(list.get(i)) ||
                !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
}

// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n+1 ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0],edge[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.second - b.second);
        int[] distance = new int[n+1];
        int[] parent = new int[n+1];
        for(int i = 0 ; i< n + 1 ; i++){
            parent[i] = i;
        }
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[1] = 0;
        pq.add(new Pair(1,0));
        while(!pq.isEmpty()){
            Pair root = pq.poll();
            int node = root.first;
            int dist = root.second;
            for(Pair pair: adj.get(node)){
                int neighbour = pair.first;
                int cost = pair.second;
                if(dist + cost < distance[neighbour]){
                    distance[neighbour] = dist + cost;
                    pq.add(new Pair(neighbour,distance[neighbour]));
                    parent[neighbour] = node;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int node = n;
        // int weight = 0;
        while(parent[node] != node){
            ans.add(node);
            node = parent[node];
        }
        if(node == 1){
            ans.add(1);
            ans.add(distance[n]);
            Collections.reverse(ans);
            return ans;
        }
        else{
            ans = new ArrayList<>();
            ans.add(-1);
            return ans;
        }
    }
}