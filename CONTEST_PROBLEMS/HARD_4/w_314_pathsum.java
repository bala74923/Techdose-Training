package CONTEST_PROBLEMS.HARD_4;

import java.util.Arrays;
import java.util.Scanner;

public class w_314_pathsum {
    static int inf= Integer.MAX_VALUE, ninf = Integer.MIN_VALUE;
    static int mod = (int)1e9+7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(),n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int K = sc.nextInt();
        solveTable(mat,K);
        solveTable2(mat,K);
    }
    static  int solveTable2(int[][] grid,int K){
        int m = grid.length, n= grid[0].length;
        int[][] dp = new int[n][K];
        //range i->m-1 to 0 ,j = n-1 to 0,sum- 0 to k-1
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int sum=0;sum<K;sum++){
                    if(i==0 && j==0){ //base case
                        dp[0][sum] = (sum+grid[0][0])%K==0?1:0;
                    }else if(i==0){
                        dp[j][sum%K] = dp[j-1][(sum+grid[i][j])%K];
                    }else if(j==0){
                        dp[j][sum%K] = dp[j][(sum+grid[i][j])%K];
                    }
                    else{
                        int left = dp[j][(sum+grid[i][j])%K];
                        int right = dp[j-1][(sum+grid[i][j])%K];
                        dp[j][sum%K] = (left%mod+ right%mod)%mod;
                    }
                }
            }

        }
        return dp[n-1][0];
    }
    static  int solveTable(int[][] grid,int K){
        int m = grid.length, n= grid[0].length;
        int[][][] dp = new int[m][n][K];

        //range i->m-1 to 0 ,j = n-1 to 0,sum- 0 to k-1
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int sum=0;sum<K;sum++){
                    if(i==0 && j==0){ //base case
                        dp[0][0][sum] = (sum+grid[0][0])%K==0?1:0;
                    }else if(i==0){
                        dp[i][j][sum%K] = dp[i][j-1][(sum+grid[i][j])%K];
                    }else if(j==0){
                        dp[i][j][sum%K] = dp[i-1][j][(sum+grid[i][j])%K];
                    }
                    else{
                        int left = dp[i-1][j][(sum+grid[i][j])%K];
                        int right = dp[i][j-1][(sum+grid[i][j])%K];
                        dp[i][j][sum%K] = (left%mod+ right%mod)%mod;
                    }
                }
            }
        }
        return dp[m-1][n-1][0];
    }
    static int solveRec(int[][] grid,int K){
        //recursive solution
         return memoise(grid,K);
    }
    static int[][][] memo;
    static int memoise(int[][] grid,int K){
        int m = grid.length, n= grid[0].length;
        memo = new int[m][n][K];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        return rec(m-1,n-1,0,grid,K);
    }
    static int rec(int i,int j,int sum,int[][] grid,int K){
        if(i<0 || j<0) return 0;
        if(i==0&&j==0) {
            return (sum+grid[0][0])%K==0?1:0;
        }
        if(memo[i][j][sum%K]!=-1)
            return memo[i][j][sum%K];
        int left = rec(i-1,j,sum+grid[i][j],grid,K);
        int right = rec(i,j-1,sum+grid[i][j],grid,K);
        return memo[i][j][sum%K] = (left%mod+ right%mod)%mod;
    }
}
