package Dp.Strings;

public class _72_Edit_Distance {
    // my iterative solution in java
        public int minDistance(String s1, String s2) {
            int N1 = s1.length(), N2 = s2.length();
            int[][] dp = new int[N1+1][N2+1];

            for(int i=0; i<=N1; i++)
                dp[i][0]= i;

            for(int j=0;j<=N2;j++)
                dp[0][j] = j;

            dp[0][0] = 0;

            for(int i = 1 ; i<=N1; i++){
                for(int j=1; j<= N2;j++){
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = 1+Math.min( dp[i][j-1],Math.min( dp[i-1][j],dp[i-1][j-1] ) );
                    }
                }
            }
            return dp[N1][N2];
        }
}
