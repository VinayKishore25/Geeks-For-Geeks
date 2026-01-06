class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int maxSum = 0;
        int currSum = 0;
        int n = arr.length;
        for(int i = 0 ; i < k ; i++){
            currSum ^= arr[i];
        }
        maxSum = currSum;
        for(int i = k ; i < n ; i++){
            currSum ^= arr[i-k];
            currSum ^= arr[i];
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}
