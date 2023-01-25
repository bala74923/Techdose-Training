package Dp.Grid;

public class _64_Minimum_Path_Sum {
    int int_max = (int)1e9;
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length ;
        int[][] dp = new int[m+1][n+1];
        // j=0
        for(int i=0; i<=m;i++)
            dp[i][0] = int_max;
        //i=0
        for(int j=0; j<=n;j++)
            dp[0][j] = int_max;
        for(int i=1; i<=m;i++){
            for(int j=1;j<=n;j++){
                if( i == 1 && j ==  1)
                    dp[i][j] = grid[0][0];
                else
                    dp[i][j] =  grid[i-1][j-1] +Math.min(dp[i-1][j],dp[i][j-1]);

            }
        }
        return dp[m][n];
    }
}
