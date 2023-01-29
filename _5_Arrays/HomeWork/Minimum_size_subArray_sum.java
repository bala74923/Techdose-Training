package _5_Arrays.HomeWork;

import java.util.TreeMap;

public class Minimum_size_subArray_sum {
    public int minSubArrayLen(int target, int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int min = (int)1e9, tot = 0;
        map.put(0,-1);
        for(int index=0;index<nums.length;index++){
            tot+= nums[index];
            int need = tot - target;
            try{
                int fl = map.floorKey(need);
                int lastIndex = map.get(fl);
                min = Math.min(min,index-lastIndex);
            }catch(Exception e){}
            map.put(tot,index);
        }
        return min==(int)1e9?0:min;
    }
}
