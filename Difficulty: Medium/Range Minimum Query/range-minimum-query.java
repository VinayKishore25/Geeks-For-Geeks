//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Minimum
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
              GfG gfg = new GfG();
            int Q = sc.nextInt();
            
            
            int st[] = gfg.constructST(arr, n);
            int l,r;
            for(int i = 0; i < Q; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                l = Math.min(a,b);
                r = Math.max(a,b);
                
                System.out.print(gfg.RMQ(st, n, l, r) + " ");
                
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/* The functions which 
builds the segment tree */
class GfG
{
    static int st[];
    public static void solve(int[] arr,int n,int l,int r,int i,int[] st){
        if(l == r){
            st[i] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        solve(arr,n,l,mid,2*i,st);
        solve(arr,n,mid+1,r,2*i+1,st);
        st[i] = Math.min(st[2*i],st[2*i+1]);
    }
    public static int[] constructST(int arr[], int n)
    {
        // Add your code here
        st = new int[4*n];
        solve(arr,n,0,n-1,1,st);
        // System.out.println(Arrays.toString(st));
        return st;
    }
    
    
    /* The functions returns the
      min element in the range
      from l and r */
      public static int solve(int s,int e,int[] st,int qs,int qe,int idx){
          if(qs > e ||  qe < s){
              return Integer.MAX_VALUE;
          }
          if(qs <= s && qe >= e){
              return st[idx];
          }
          int mid = (s+e) >> 1;
          int l = solve(s,mid,st,qs,qe,2*idx);
          int r = solve(mid+1,e,st,qs,qe,2*idx+1);
          return Math.min(l,r);
      }
    public static int RMQ(int st[], int n, int l, int r)
    {
       // Add your code here
        return solve(0,n-1,st,l,r,1);
    }
    
    
}