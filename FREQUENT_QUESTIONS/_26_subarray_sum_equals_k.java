package FREQUENT_QUESTIONS;

import java.util.HashMap;
import java.util.Map;

public class _26_subarray_sum_equals_k {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum =0,res = 0;
        map.put(0,1);
        for(int n:nums){
            sum+=n;
            int need = sum-k;
            res+= map.getOrDefault(need,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
