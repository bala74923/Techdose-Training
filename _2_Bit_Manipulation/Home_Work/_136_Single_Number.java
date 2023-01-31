package _2_Bit_Manipulation.Home_Work;

public class _136_Single_Number {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int n:nums)
            xor  = xor^n;
        return xor;
    }
}
