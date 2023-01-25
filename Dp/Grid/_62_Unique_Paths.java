package Dp.Grid;

public class _62_Unique_Paths {
    public int uniquePaths(int m, int n) {
        ///i-> m-1 to 0, j-> n-1 to 0
        int[] dp = new int[n+1];

        for(int i=1;i<= m; i++){
            for(int j=1;j<=n;j++){
                if( i ==1 && j ==1 )
                    dp[j] = 1;
                else
                    dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n];
    }
}
