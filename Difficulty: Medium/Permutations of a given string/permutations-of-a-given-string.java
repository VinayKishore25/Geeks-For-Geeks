//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public void solve(StringBuilder sb,HashSet<String> hs,List<String> al,int i,int n){
        if(i >= n) return;
        if(i == n - 1){
            if(!hs.contains(sb.toString())){
                al.add(sb.toString());
                hs.add(sb.toString());
            }
        }
        for(int j = i ; j < n ; j++){
            swap(sb,i,j);
            solve(sb,hs,al,i+1,n);
            swap(sb,i,j);
        }
    }
    public List<String> find_permutation(String s) {
        // Code here
        StringBuilder sb = new StringBuilder(s);
        HashSet<String> hs = new HashSet<>();
        List<String> al = new ArrayList<>();
        int n = sb.length();
        solve(sb,hs,al,0,n);
        Collections.sort(al);
        return al;
    }
    public void swap(StringBuilder sb,int i,int j){
        char temp = sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,temp);
    }
}