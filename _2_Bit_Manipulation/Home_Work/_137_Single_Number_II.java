package _2_Bit_Manipulation.Home_Work;

public class _137_Single_Number_II {
    // o(nlogn)
    public int singleNumber(int[] nums) {
        int res = 0 ;
        for(int i=0 ; i<=31; i++){
            int count = 0;
            for(int value: nums){
                if( (value&(1<<i))!=0 ){
                    count++;
                }
            }
            if(count%3 == 1){
                res = res|(1<<i);
            }
        }
        return res;
    }
    //o(n)
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0 ;
        for(int value: nums){
            ones = (ones^value)&(~twos);
            twos = (twos^value)&(~ones);
        }
        return ones;
    }
}
