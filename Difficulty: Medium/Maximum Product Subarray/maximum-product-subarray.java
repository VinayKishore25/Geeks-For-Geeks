class Solution {
    int maxProduct(int[] arr) {
        // code here
        long i = 1 , j = 1 ; 
        int n = arr.length;
        long max = Integer.MIN_VALUE;
        for(int k = 0 ; k < n ; k++)
        {
            if(i==0)
            i=1;
            if(j==0)
            j=1;
            i*=arr[k];
            j*=arr[n-k-1];
            max = Math.max(max,Math.max(i,j));
        }
        return (int)max;
    }
}