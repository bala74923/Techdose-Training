package SORTING_ALGORITHMS.Assignments;

import java.util.Arrays;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        int max = nums[0];
        for(int val: nums) max = Math.max(max,val);
        int N= nums.length, times  = (int)(Math.log(max)/Math.log(10));
        for(int t=0;t<=times;t++){
            int[] out = new int[N];
            int[] count = new int[10];
            for(int val: nums){
                int index =  (val/(int)Math.pow(10,t))%10;
                count[index]++;
            }
            for(int i=1;i<10;i++) count[i]+= count[i-1];
            for(int i=N-1;i>=0;i--){
                int index =  (nums[i]/(int)Math.pow(10,t))%10;
                out[--count[index]] = nums[i];
            }
            nums = out;
        }
        System.out.println(Arrays.toString(nums));
        max = 0;
        for(int i=1;i<N;i++){
            max = Math.max(max,nums[i]-nums[i-1]);
        }
        return max;
    }
}
