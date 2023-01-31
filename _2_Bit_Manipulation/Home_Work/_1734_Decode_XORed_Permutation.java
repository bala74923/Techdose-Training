package _2_Bit_Manipulation.Home_Work;

public class _1734_Decode_XORed_Permutation {
    public int[] decode(int[] encoded) {
        int xor = 0, curr_xor = 0;
        int N = encoded.length;

        for(int i=1;i<=N+1 ;i++)
            xor = xor^i;

        for(int i=0;i<N;i+=2)
            curr_xor = curr_xor^encoded[i];
        int last = curr_xor ^ xor ;
        int[] res = new int[N+1];
        res[N] = last;
        for(int i=N-1;i>=0;i--){
            last = last^encoded[i];
            res[i] = last;
        }
        return res;
    }
}
