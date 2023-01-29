package _17_Dp.Knapsack;
import java.util.Arrays;
public class _322_Coin_Change {

    class Solution {
        public int coinChange(int[] coins, int amount) {
            int N = coins.length , int_max = amount+1;
            int[] dp = new int[amount+1];
            Arrays.fill(dp,int_max) ;
            dp[0] = 0;

            for(int ind= 1;ind<=N ; ind++){
                for(int sum = 0;sum<=amount; sum++){
                    int pick= int_max;
                    if(sum>=coins[ind-1]){
                        pick = 1+ dp[sum-coins[ind-1]];
                    }
                    int not_pick = dp[sum];
                    dp[sum] = Math.min(pick, not_pick);
                }
            }

            return dp[amount]== int_max? -1: dp[amount];
        }
    }

}
