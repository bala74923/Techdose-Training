package Dp.Digit_Dp;

import java.util.Scanner;
import java.util.*;
public class NUMTSN_369_Numbers {
    static int mod = (int)1e9+7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test  = sc.nextInt();
        while(test-->0){
            String left = sc.next();
            String right = sc.next();
            init();
            long l  = f(0,1,0,0,0,left);
            init();
            long r = f(0,1,0,0,0,right);
            System.out.println(r-l+(bruteforce(left)?1:0));
        }
    }
    static  boolean bruteforce(String s){
        int[] arr = new int[4];
        for(char c: s.toCharArray()){
            int curr = c-'0';
            if(curr%3==0) arr[curr/3]++;
        }
        return arr[1]==arr[2] && arr[2] ==arr[3] && arr[1]>0;
    }
    static long[][][][][] dp = new long[51][2][51][51][51];
    static void init(){
        for(long[][][][] dp1: dp){
            for(long[][][] dp2: dp1){
                for(long[][] dp3: dp2){
                    for(long[] dp4: dp3){
                        Arrays.fill(dp4,-1);
                    }
                }
            }
        }
    }
    //static Stack<Integer> st = new Stack<>();
    static long f(int ind,int tight,int a,int b,int c,String s){
        if(ind == s.length()) {
            if(a==b && b==c && a>0){
               // System.out.println(st);
                return 1;
            } return 0;
        }
        if(dp[ind][tight][a][b][c] !=-1)
            return dp[ind][tight][a][b][c];
        int ub = tight==1? s.charAt(ind)-'0': 9;
        long res = 0;
        int done = 1;
        for(int k = 3;k<=ub;k+=3){
            int na = a,nb = b,nc = c;
            if(k==3) na++; if(k==6) nb++; if(k==9) nc++;
           // st.push(k);
            res = add(res , f(ind+1,tight&(ub==k?1:0), na,nb,nc, s) );
            //st.pop();
            done++;
        }
        // other than 3,6,9
        int rem = ub-done-1;//except that upper bound
        res = add(res, mul(rem, f(ind+1,0,a,b,c,s)));
        if(ub%3!=0)
            res = add(res, f(ind+1,tight & 1,a,b,c,s));
        return dp[ind][tight][a][b][c]= res;
    }
    static long add(long a,long b){
        return ((a%mod)+(b%mod))%mod;
    }
    static long mul(long a,long b){
        return ((a%mod) * (b%mod))%mod;
    }
}
