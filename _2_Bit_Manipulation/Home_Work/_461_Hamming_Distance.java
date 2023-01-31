package _2_Bit_Manipulation.Home_Work;

public class _461_Hamming_Distance {
    public int hammingDistance(int x, int y) {
        x = x^y;
        int res = 0;
        while(x!=0){
            res++;
            x = x&(x-1);
        }
        return res;
    }
}
