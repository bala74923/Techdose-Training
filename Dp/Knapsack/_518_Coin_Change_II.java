package Dp.Knapsack;

public class _518_Coin_Change_II {
    class Solution {
        public int change(int amount, int[] coins) {
            int N = coins.length ;
            int[] dp = new int[amount+1] ;
            dp[0] = 1 ;
            for(int ind = 1;ind<= N; ind++){
                for(int sum = 0 ;sum<=amount ; sum ++){
                    int pick = 0;
                    if( sum>=coins[ind-1] )
                        pick = dp[ sum-coins[ind-1]] ;
                    int not_pick = dp[sum];
                    dp[sum] = pick + not_pick ;
                }
            }
            return dp[amount] ;
        }
    }
}
