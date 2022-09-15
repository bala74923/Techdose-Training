package FREQUENT_QUESTIONS;

public class _37_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int sum = 0,max=Integer.MIN_VALUE;
        for(int n:nums){
            sum+=n;
            max = Math.max(max,sum);
            if(sum<0) sum = 0;
        }
        return max;
    }
}
