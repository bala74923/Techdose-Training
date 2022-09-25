package FREQUENT_QUESTIONS;
import java.util.Arrays;
public class _84_coin_change {
    int max= (int)1e9;
    public int coinChange(int[] coins, int amount) {
        return opt(coins,amount);
    }
    int[][] memo;
    int memoise(int[] arr,int t){
        int N = arr.length;
        memo = new int[N+1][t+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=t;j++){
                memo[i][j] = -1;
            }
        }
        int ans =  f(N,t,arr);
        return ans>t?-1:ans;
    }
    int f(int ind,int sum,int[] arr){
        if(sum==0) return 0;
        if(ind==0) return max;
        if(memo[ind][sum]!=-1)
            return memo[ind][sum];
        int pick = max;
        if(sum>=arr[ind-1]){
            pick = 1 + f(ind,sum-arr[ind-1],arr);
        }
        int  notPick = f(ind-1,sum,arr);
        return memo[ind][sum] = Math.min(pick,notPick);
    }
    int tab(int[] arr,int t){
        int N = arr.length;
        int[][] dp = new int[N+1][t+1];
        Arrays.fill(dp[0],max);
        dp[0][0] = 0;
        for(int ind=1;ind<=N;ind++){
            for(int sum=1;sum<=t;sum++){
                int pick = max;
                if(sum>=arr[ind-1]){
                    pick = 1 + dp[ind][sum-arr[ind-1]];
                }
                int  notPick = dp[ind-1][sum];
                dp[ind][sum] = Math.min(pick,notPick);

            }
        }
        return dp[N][t]>t?-1:dp[N][t];
    }
    int opt(int[] arr,int t){
        int N = arr.length;
        int[] dp = new int[t+1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int ind=1;ind<=N;ind++){
            for(int sum=1;sum<=t;sum++){
                int pick = max;
                if(sum>=arr[ind-1]){
                    pick = 1 + dp[sum-arr[ind-1]];
                }
                int  notPick = dp[sum];
                dp[sum] = Math.min(pick,notPick);

            }
        }
        return dp[t]>t?-1:dp[t];
    }

}
