package _2_Bit_Manipulation.Home_Work;

public class _201_Bitwise_AND_of_Numbers_Range {
    public int rangeBitwiseAnd(int m, int n) {
        int del = 0;
        while(m>0 && n>0){
            if(m==n) return m<<del;
            m>>=1 ; n>>=1; del++;
        }
        return 0;
    }
}
