package Dp.Strings;

public class _647_Palindromic_Substrings {

    // watch LCS_LPS video of Techdose for explanation
        public int countSubstrings(String s) {
            // dp on sliding window
            int N = s.length();
            boolean[][] dp =  new boolean[N+1][N+1];
            int res = 0;
            for(int i = 0;i<N;i++){
                dp[i][i] = true; res ++;
            }
            // i goes from 1 to N, j goes from N to i+1
            for(int i=N;i>=1;i--){
                // i==j already this case has been seen
                for(int j=i+1;j<=N;j++){
                    if(s.charAt(i-1) == s.charAt(j-1) && (j-i<=2 || dp[i+1][j-1])){
                        dp[i][j] = true;
                        res++;
                    }

                }
            }
            return res;
        }

}
