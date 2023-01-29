package _9_Hash_Map.ASSIGNMENT;

import java.util.HashMap;
import java.util.Map;

public class _560_Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int curr = 0,res = 0;
        for(int n: nums){
            curr+=n;
            int need = curr-k;
            res+=map.getOrDefault(need,0);
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        return res;
    }
}
