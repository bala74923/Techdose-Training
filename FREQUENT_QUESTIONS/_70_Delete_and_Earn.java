package FREQUENT_QUESTIONS;

import java.util.Arrays;

public class _70_Delete_and_Earn {
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for(int n:nums) max= Math.max(max,n);
        int[] hash = new int[max+1];
        for(int n:nums) hash[n]++;
        return tab(hash);
    }
    int tab(int[] hash){
        int max= hash.length-1;
        int[] dp = new int[max+1];
        dp[0] = 0;
        for(int ind=1;ind<=max;ind++){
            int del = ind*hash[ind]+ (ind==1?0:dp[ind-2]);
            int not_del = dp[ind-1];
            dp[ind] = Math.max(del,not_del);
        }
        return dp[max];
    }
    int[] memo ;
    int memoise(int[] hash){
        int max = hash.length-1;
        memo = new int[max+1];
        Arrays.fill(memo,-1);
        return f(max,hash);
    }
    int f(int ind,int[] hash){
        if(ind<=-1) return 0;
        if(memo[ind]!=-1) return memo[ind];
        int del = ind*hash[ind]+ f(ind-2,hash);
        int not_del = f(ind-1,hash);
        return memo[ind] = Math.max(del,not_del);
    }
}
