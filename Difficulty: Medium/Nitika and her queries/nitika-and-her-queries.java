//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(arr[0]);
            int Q = Integer.parseInt(arr[1]);
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[N];
            for(int i = 0;i < N;i++)
                a[i] = Integer.parseInt(a1[i]);
            int query[][] = new int[Q][2];
            for(int i = 0;i < Q;i++){
                String a2[] = in.readLine().trim().split("\\s+");
                query[i][0] = Integer.parseInt(a2[0]);
                query[i][1] = Integer.parseInt(a2[1]);
            }
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.specialXor(N, Q, a, query);
            for(int i = 0;i < Q;i++)
                System.out.println(ans.get(i));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void BuildTree(int[] segmentTree,int l,int r,int i,int[] a){
        if(l == r){
            segmentTree[i] = a[l];
            return;
        }
        int mid = (l+r) >> 1;
        BuildTree(segmentTree,l,mid,2*i+1,a);
        BuildTree(segmentTree,mid+1,r,2*i+2,a);
        segmentTree[i] = segmentTree[2*i+1] ^ segmentTree[2*i+2];
    }
    static int query(int[] segmentTree,int qs,int qe,int s,int e,int i){
        if(qs > e || qe < s) {
            return 0;
        }
        if(qs <= s && qe >= e) return segmentTree[i];
        int mid = (s+e) >> 1;
        int left = query(segmentTree,qs,qe,s,mid,2*i+1);
        int right = query(segmentTree,qs,qe,mid+1,e,2*i+2);
        return left ^ right;
    }
    static List<Integer> specialXor(int n, int q, int a[], int query[][])
    {
        // code here
        int[] segmentTree = new int[4*n];
        List<Integer> al = new ArrayList<>();
        BuildTree(segmentTree,0,n-1,0,a);
        for(int i = 0 ; i < q ; i++){
            int l = query[i][0] - 1;
            int r = query[i][1] - 1;
            int left = query(segmentTree,0,l-1,0,n-1,0);
            int right = query(segmentTree,r+1,n,0,n-1,0);
            al.add(left^right);
        }
        return al;
    }
}