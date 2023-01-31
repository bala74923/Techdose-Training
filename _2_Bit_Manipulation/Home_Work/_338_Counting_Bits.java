package _2_Bit_Manipulation.Home_Work;

public class _338_Counting_Bits {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i] = dp[i>>1]+(i&1);
        }
        return dp;
    }
}
