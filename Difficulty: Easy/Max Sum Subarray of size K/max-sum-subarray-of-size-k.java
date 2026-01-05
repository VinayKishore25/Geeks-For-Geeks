class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        long sum = 0 ;
        long res = 0;
        int N =  arr.length;
        int i = 0;
        for(i = 0 ; i < k ;i++)
        {
            sum+=arr[i];
        }
        res = Math.max(sum,res);
        i = 0 ;
        for(int j = k ; j < N ; j++)
        {
            sum -= arr[i++];
            sum += arr[j];
            res = Math.max(res,sum);
        }
        return (int)res;
    }
}