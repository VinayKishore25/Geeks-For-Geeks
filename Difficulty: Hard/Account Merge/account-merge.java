//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases
        while (T-- > 0) {
            int n = sc.nextInt(); // Number of accounts
            ArrayList<ArrayList<String>> accounts = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt(); // Number of emails + name
                ArrayList<String> temp = new ArrayList<>();
                for (int j = 0; j < x; j++) {
                    temp.add(sc.next()); // Read name/emails
                }
                accounts.add(temp);
            }

            // Calling the accountsMerge function
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> res = obj.accountsMerge(accounts);

            // Sorting individual accounts' emails
            for (int i = 0; i < res.size(); i++) {
                Collections.sort(res.get(i));
            }

            // Sorting the entire list exactly like C++'s sort(res.begin(), res.end());
            Collections.sort(res, new Comparator<ArrayList<String>>() {
                @Override
                public int compare(ArrayList<String> a, ArrayList<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        int cmp = a.get(i).compareTo(b.get(i));
                        if (cmp < 0) return -1;
                        if (cmp > 0) return 1;
                    }
                    if (al < bl) return -1;
                    if (al > bl) return 1;
                    return -1; // Exact match with C++ behavior
                }
            });

            // Printing the output in the required format
            System.out.print("[");
            for (int i = 0; i < res.size(); i++) {
                System.out.print("[");
                for (int j = 0; j < res.get(i).size(); j++) {
                    if (j != res.get(i).size() - 1) {
                        System.out.print(res.get(i).get(j) + ", ");
                    } else {
                        System.out.print(res.get(i).get(j));
                    }
                }
                if (i != res.size() - 1) {
                    System.out.println("], ");
                } else {
                    System.out.print("]");
                }
            }
            System.out.println("]");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
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
        if(parent[node] == node){
            return node;
        }
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
    static ArrayList<ArrayList<String>> accountsMerge(
        ArrayList<ArrayList<String>> accounts) {
        // code here
        ArrayList<ArrayList<String>> finalAccounts = new ArrayList<>();
        ArrayList<ArrayList<String>> finalEmail = new ArrayList<>();
        HashMap<String,Integer> mailNodeMap = new HashMap<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n+1);
        for(int i = 0 ; i < n ; i++){
            for(int j = 1 ; j < accounts.get(i).size() ; j++){
                String currentMail = accounts.get(i).get(j);
                if(!mailNodeMap.containsKey(currentMail)){
                    mailNodeMap.put(currentMail,i);
                }
                else{
                    ds.union(mailNodeMap.get(currentMail),i);
                }
            }
            finalEmail.add(new ArrayList<>());
        }
        for(String email : mailNodeMap.keySet()){
            int node = mailNodeMap.get(email);
            int u = ds.findParent(node);
            finalEmail.get(u).add(email);
        }
        n = finalEmail.size();
        // System.out.println(finalEmail);
        int k = 0;
        for(int i = 0 ; i < n ; i++){
            int m = finalEmail.get(i).size();
            if(m > 0){
                finalAccounts.add(new ArrayList<>());
                finalAccounts.get(k).add(accounts.get(i).get(0));
                Collections.sort(finalEmail.get(i));
                for(int j = 0 ; j < m ; j++){
                    finalAccounts.get(k).add(finalEmail.get(i).get(j));
                }
                k++;
            }
        }
        return finalAccounts;
    }
}
