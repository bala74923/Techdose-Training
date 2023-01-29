package _5_Arrays.HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;//to skip duplicates

            int lo = i+1,hi = nums.length-1,t =-nums[i];
            while(lo<hi){
                int sum = nums[lo]+nums[hi];
                if(sum==t){
                    List<Integer> sub = new ArrayList<>();
                    sub.add(nums[i]);sub.add(nums[lo]);sub.add(nums[hi]);
                    list.add(sub);
                    int left = nums[lo], right=  nums[hi];

                    while(lo<hi && left==nums[lo]) lo++; //skipping duplicates
                    while(lo<hi && right==nums[hi]) hi--; //skipping duplicates
                }else if(sum>t) hi--;
                else lo++;
            }
        }
        return list;
    }
}
