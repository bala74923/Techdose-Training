package _9_Hash_Map.ASSIGNMENT;

import java.util.HashMap;
import java.util.Map;

public class _525_Contiguous_Array {
    class Solution {
        public int findMaxLength(int[] nums) {
            int sum = 0,N = nums.length;
            int maxi =0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0,-1);
            for(int i=0;i<N;i++){
                if(nums[i]==0) nums[i]=-1; //for low=-1,hi = 1, sum(lo+hi) 0
                sum+= nums[i];
                if(map.get(sum)!=null && i-map.get(sum)>1)
                    maxi = Math.max(maxi, i-map.get(sum));
                else map.put(sum,i);
            }
            return maxi;
        }
    }
}
