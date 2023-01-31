package _2_Bit_Manipulation.Home_Work;

public class _169_Majority_Element {
    public int majorityElement(int[] nums) {
        int count = 0, major = 0 ;
        for(int value: nums){
            if(count== 0){
                major = value ;
            }
            if(major == value)
                count++;
            else
                count--;
        }
        return major ;
    }
}
