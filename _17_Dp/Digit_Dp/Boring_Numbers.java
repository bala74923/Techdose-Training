package _17_Dp.Digit_Dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Boring_Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        rec_stack = new Stack<>();
        int t = 1;
        while(test-->0){
           long l = sc.nextLong()-1, r = sc.nextLong();
           String str_l = l+"", str_r= r+"";
           intialiseMem(str_l.length());
           long val_l = calc(str_l);

           intialiseMem(str_r.length());
           long val_r = calc(str_r);

            long result = val_r-val_l;
            System.out.println("Case #"+t+": "+result);
            t++;
        }
    }
    static void intialiseMem(int n){
        mem = new long[n+1][2][2][2];
        for(long[][][] m1: mem){
            for(long[][] m2: m1){
                for(long[] m3: m2){
                    Arrays.fill(m3 ,-1);
                }
            }
        }

    }
    static Stack<Integer> rec_stack;
    static void push(int n){rec_stack.push(n);}
    static int  pop(){return rec_stack.pop();}
    static long[][][][] mem;
    static long calc(String s){
        // see for the first number
        long res = 0;
        // not start condition
        //push(0);
        res+= f(1, 0 , 1, 0,s);
        //pop();
        // start but not tight

        int ub = s.charAt(0)-'0';//System.out.println(ub+"ub =>"+s);
        for(int first= 1;first< ub;first ++){
            if(first%2 == 1){
              //push(first);
                res+= f(1,1, 0 ,0 ,s);
                //pop();
            }
        }
        // tight condition
        // occurs when ub is odd
        if(ub%2 ==1) {
            //push(ub);
            res += f(1, 1, 0, 1, s);
            //pop();
        }
        return res;
    }
    //{idx- 0 to s.length(), started = (0,1), pos = (0,1), tight=(0,1)
    static long f(int idx,int started,int pos,int tight,String s){
       if(idx==s.length()){
//           if(started==1){
//               //System.out.println(rec_stack);
//             //  System.out.printf(" prams=%d st%d pos%d tight%d s=%s\n",idx,started,pos,tight,s);
//           }

           return started==1? 1: 0; // if it is not even started then 0
       }
       if(mem[idx][started][pos][tight]!=-1)
           return mem[idx][started][pos][tight];
       long res = 0;
       // if not started then may be dont start now
        if(started == 0){
            //push(0);
            res+=  f(idx+1, 0 ,pos , 0 ,s );
            //pop();
        }
        int ub = tight==1? s.charAt(idx)-'0': 9;
        for(int k = started==1? 0: 1;k<=ub;k++){
            // if not started dont do k = 0
            if((k&1) == pos ){
                //push(k);
                res+= f(idx+1, 1 ,pos^1, tight&(ub == k?1:0), s);
                //pop();
            }
        }
        return mem[idx][started][pos][tight] = res;
    }
}
