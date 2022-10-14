package CONTEST_PROBLEMS.HARD_4;

import java.util.Arrays;
import java.util.Scanner;

public class _313_MaximumDeletionsOnString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solve(s));
    }
    static int base=-1,mod = (int)1e9+7;
    static long[] hash,pow;
    static int solve(String s){
        base = 131;
        computeHash(s);
        return memoise(s);
    }
    static int[] memo;
    static int memoise(String s){
        memo = new int[s.length()+1];
        Arrays.fill(memo,-1);
        return rec(0,s);
    }
    static int rec(int ind,String s){
        if(ind>=s.length()) return 0;
        if(memo[ind]!=-1) return memo[ind];
        int res = 1; // we can delete the entire string
        for(int len = 1;len<s.length();len++){
            int li = ind, lj = ind+len-1, ri = ind+len, rj= ind+(2*len)-1;
            if(rj<s.length()){
                // compare two substrings
                if(equal(s,li,lj,ri,rj)){
                    res = Math.max(res, 1+ rec(ri,s));
                }
            }
        }

        return memo[ind] = res;
    }
    static void computeHash(String s){
        int N = s.length();
        hash = new long[N+2];pow = new long[N+2];
        pow[0]=1;
        for(int i=1;i<=N;i++){
            pow[i] = pow[i-1]*base;
            hash[i] = (hash[i-1]*base) + (s.charAt(i-1));
        }
        /*
        hash[] = 0
        hash[a] = a
        hash[ab] = ax + b
       hash[ abc ] = (ax +b)x+ c =  ax^2 + bx +c
         */
    }
    static long get(int i,int j){
        return hash[j]-hash[i-1]*pow[j-i+1]; // here pow is stored in array for o(1) time retrieval
    }
    static boolean equal(String s,int li,int lj, int ri,int rj){
        return get(li+1,lj+1) ==get(ri+1,rj+1);
    }
}
