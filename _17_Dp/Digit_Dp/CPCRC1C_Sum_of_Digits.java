package _17_Dp.Digit_Dp;
// qn link - https://www.spoj.com/problems/CPCRC1C/
import java.util.Arrays;
import java.util.Scanner;

public class CPCRC1C_Sum_of_Digits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = sc.nextInt();
            String left = (a-1)+"";
            String right= sc.next();
            if(a==-1) break;
            // calculate for right
            init();
            long r = f(0,0,1,right);
            //calculate for left
            init();
            long l = f(0,0,1 ,left);

            //right-(left-1) print the answer
            System.out.println(r-l);
        }
    }
    static long[][][] mem = new long[10][100][2];
    static void init(){
        for(long[][]mem12: mem) {
            for (long[] mem1 : mem12)
                Arrays.fill(mem1, -1);
        }
    }
    static long f(int ind,int sum,int tight,String s){
        if(ind==s.length())
            return sum;
        if(mem[ind][sum][tight] !=-1)
            return mem[ind][sum][tight];
        long res = 0;
        int ub = tight==1? s.charAt(ind)-'0': 9;
        for(int k=0;k<=ub;k++){
            res = res+ f(ind+1, sum+k,tight&(ub==k?1:0),s);
        }
        //System.out.printf("%s ind = %d tight=%d res=%d\n",s,ind,tight,res);
        return mem[ind][sum][tight]= res;
    }
}
