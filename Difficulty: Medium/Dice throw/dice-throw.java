class Solution {
    static int noOfWays(int m, int n, int x) {
         int[][] dp = new int[n+1][x+1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                dp[i][j] = 0;
                for (int f = 1; f <= m; f++) {
                    if (j - f >= 0) {
                        dp[i][j] += dp[i-1][j-f];
                    }
                }
            }
        }

        return dp[n][x];
    }
};