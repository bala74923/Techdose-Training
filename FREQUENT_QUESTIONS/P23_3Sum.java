package FREQUENT_QUESTIONS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P23_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<nums.length;){
            int need = -nums[i] ,lo =i+1,hi = nums.length-1;
            while(lo<hi){
                int sum = nums[lo]+nums[hi];
                if(sum==need){
                    List<Integer> sub = new ArrayList<>();
                    sub.add(nums[i]);sub.add(nums[lo]);sub.add(nums[hi]);
                    list.add(sub);
                    int pre1 = nums[lo],pre2=nums[hi];
                    while(lo<hi && pre1==nums[lo]) lo++;
                    while(lo<hi && pre2==nums[hi]) hi--;
                }else if(sum>need) hi--;
                else lo++;
            }
            while(i<nums.length &&-need==nums[i]) i++;
        }
        return list;
    }
}
