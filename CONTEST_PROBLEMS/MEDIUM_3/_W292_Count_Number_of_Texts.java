package CONTEST_PROBLEMS.MEDIUM_3;

import java.util.Arrays;
import java.util.Scanner;

public class _W292_Count_Number_of_Texts {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String input = sc.next();
        System.out.println(solve(input));
    }
    static int mod = (int)Math.pow(10,9)+7;
    static int[] memo;
    static int solve(String s){
        memo = new int[s.length()+1];
        Arrays.fill(memo,-1);
        return rec(0,s)%mod;
    }
    static int rec(int index,String s){
        if(index==s.length()) return 1;
        if(memo[index]!=-1)
            return memo[index];
        int next  = index;
        int sum = 0,max = s.charAt(index)=='9'||s.charAt(index)=='7'?4:3;
        while(next<s.length() && s.charAt(next)==s.charAt(index) && next<index+max){
            sum= ((sum%mod) +  (rec(next+1,s)%mod))%mod;
            next++;
        }
        //System.out.printf("sum=%d index = %d\n",sum,index);
        return memo[index] = (sum%mod);
    }
}
