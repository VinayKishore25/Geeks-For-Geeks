class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        if(n <= 2)
        return 0;
        long[] l = new long[n];
        long[] r = new long[n];
        long t = 0 ;
        l[0] = arr[0];
        r[n-1] = arr[n-1];
        for(int i = 1 ; i < n ; i++)
        {
            l[i] = Math.max(l[i-1],arr[i]);
        }
        for(int i = n - 2 ; i >= 0 ; i--)
        {
            r[i] = Math.max(r[i+1],arr[i]);
        }
        for(int i = 0 ; i < n ; i++)
        {
            t += Math.min(l[i],r[i]) - arr[i];
        }
        return (int)t;
    }
}
