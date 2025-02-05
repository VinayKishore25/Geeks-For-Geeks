//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

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
class Solution {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        int n = rows;
        int m = columns;
        int[][] distance = new int[n][m];
        for(int[] row : distance){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b) -> a.third - b.third);
        pq.add(new Triplet(0,0,0));
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!pq.isEmpty()){
            Triplet triplet = pq.poll();
            int i = triplet.first;
            int j = triplet.second;
            int cost = triplet.third;
            if(i == n - 1 && j == m - 1){
                return cost;
            }
            // System.out.println(pq);
            for(int k = 0 ; k < 4 ; k++){
                int nr = i + directions[k][0];
                int nc = j + directions[k][1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    int currEffort = Math.max(Math.abs(heights[nr][nc] - heights[i][j]),cost);
                    if(currEffort < distance[nr][nc]){
                        distance[nr][nc] = currEffort;
                        pq.add(new Triplet(nr,nc,currEffort));
                    }
                }
            }
        }
        return -1;
    }
}
