package Arrays.HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class _4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue; // same element can be skipped
            // same element can be skipped
            for(int j=i+1;j<nums.length;j++){
                int lo = j+1,hi = nums.length-1;
                if(j>i+1 && nums[j]==nums[j-1]) continue; // same element can be skipped

                long need= (long)target-nums[i]-nums[j];
                while(lo<hi){
                    if(nums[lo]==need-nums[hi]){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);list.add(nums[j]);list.add(nums[lo]);list.add(nums[hi]);
                        res.add(list);
                        int left = nums[lo], right = nums[hi];
                        while(lo<hi && left==nums[lo]) lo++;
                        while(lo<hi && right==nums[hi]) hi--;
                    }else if (nums[lo]>need-nums[hi]) hi--;
                    else lo++;
                }
            }
        }
        return  res;
    }
}
