package Dp.Strings;

public class LPS_Subsequence {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int N = s.length();
            // make it iterative
            int[][] dp = new int[N+1][N+1];
            // left-> 0 to N-1, right -> N-1 to left

            for(int i=0;i<N;i++)
                dp[i][i]= 1;
            for(int left=N-1;  left>=0;left--){
                for(int right = left+1; right< N; right++){
                    if(s.charAt(left) == s.charAt(right))
                        dp[left][right] = 2+ dp[left+1][right-1];
                    else
                        dp[left][right] = Math.max(dp[left+1][right], dp[left][right-1]);
                }
            }
            return dp[0][N-1];
        }
    }
}
