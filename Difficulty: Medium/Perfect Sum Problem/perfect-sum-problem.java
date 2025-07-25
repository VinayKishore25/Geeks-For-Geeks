class Solution {
    // Function to calculate the number of subsets with a given sum
    public static int subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int[][] dp = new int[n][k+1];
        // for(int i = 0 ; i < n ; i++){
        //     dp[i][0] = 1;
        // }
        if(arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if(arr[0] != 0 && arr[0] <= k)
        dp[0][arr[0]] = 1;
        for(int i = 1 ; i < n ; i++){
            for(int target = 0 ; target <= k ; target++){
                int pick = 0;
                if(arr[i] <= target) pick = dp[i-1][target-arr[i]];
                int notPick = dp[i-1][target];
                dp[i][target] = pick + notPick;
            }
        }
        return dp[n-1][k];
    }
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        return subsetSumToK(n,target,nums);
        
    }
}