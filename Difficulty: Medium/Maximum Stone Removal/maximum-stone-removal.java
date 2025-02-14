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
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr, n);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class DisjointSet{
    int n;
    int[] parent;
    int[] size;
    DisjointSet(int n){
        this.n = n;
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        size = new int[n];
        Arrays.fill(size,1);
    }
    int findParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }
    void union(int u,int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(size[pu] >= size[pv]){
            size[pu] += size[pv];
            parent[pv] = pu;
        }
        else{
            size[pv] += size[pu];
            parent[pu] = pv;
        }
    }
}
class Solution {

    int maxRemove(int[][] stones, int n) {
        // Code here
        int maxRow = 0;
        int maxCol = 0;
        for(int[] loc : stones){
            maxRow = Math.max(maxRow,loc[0]);
            maxCol = Math.max(maxCol,loc[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        HashMap<Integer,Integer> stoneMap = new HashMap<>();
        for(int[] stone : stones){
            int row = stone[0];
            int col = stone[1] + maxRow + 1;
            ds.union(row,col);
            stoneMap.put(row,1);
            stoneMap.put(col,1);
            
        }
        int count = 0;
        for(int stone : stoneMap.keySet()){
            if(ds.findParent(stone) == stone){
                count++;
            }
        }
        return n - count;
    }
};
