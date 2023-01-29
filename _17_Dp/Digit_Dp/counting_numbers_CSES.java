package _17_Dp.Digit_Dp;

import java.util.Scanner;
import java.util.Arrays;

 public class counting_numbers_CSES {
    static long[][][][] mem = new long[20][11][2][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long left = sc.nextLong(), right = sc.nextLong();
        init();
        long l = f(0,10,1,0, (left-1)+"");

        init(); // initalising all again to -1 as right str is diff than left
        long r = f(0,10,1,0,right+"");
        System.out.println(r-l);
    }
    // consider intial prev as 10 so 0-9 are match for first element
    static long f(int ind,int prev,int tight,int started,String s){
        if(ind== s.length())
            return 1L;
        if(mem[ind][prev][tight][started]!=-1)
            return mem[ind][prev][tight][started];
        long res = 0;
        int ub = tight==1? s.charAt(ind)-'0': 9;
        for(int k =0;k<=ub;k++){
            if(prev!=k || started ==0 ){
                res = res+ f(ind+1,k, tight&(ub==k?1:0),(k>0?1:0)|started, s);
            }
        }
        return mem[ind][prev][tight][started] = res;
    }
    static void init(){
        for(long[][][] mem1: mem){
            for(long[][] dp: mem1){
                for(long[] dp1: dp)
                    Arrays.fill(dp1,-1);
            }
        }

    }
}
