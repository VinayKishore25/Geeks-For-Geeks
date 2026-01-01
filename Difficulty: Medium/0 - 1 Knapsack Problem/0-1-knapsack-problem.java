class Solution {
    public int f(int W,int[] val, int[] w,int i){
        if(W == 0){
            return 0;
        }
        if(i == 0){
            if(w[i] <= W){
                return val[i];
            }
            else{
                return 0;
            }
        }
        int pick = 0;
        int notPick = 0;
        if(w[i] <= W){
            pick = val[i] + f(W - w[i],val,w,i-1);
        }
        notPick = f(W,val,w,i-1);
        return Math.max(pick,notPick);
    }
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = wt.length;
        int[][] dp = new int[n][W+1];
        for(int w = 0 ; w < W + 1 ; w++){
            if(wt[0] <= w){
                dp[0][w] = val[0];
            }
        }
        for(int i = 1 ; i < n ; i++){
            int pick = 0;
            int notPick = 0;
            for(int w = 0 ; w < W + 1 ; w++){
                if(wt[i] <= w){
                    pick = val[i] + dp[i - 1][w - wt[i]];
                }
                notPick = dp[i-1][w];
                dp[i][w] = Math.max(pick,notPick);
            }
        }
        return dp[n-1][W];
    }
}
