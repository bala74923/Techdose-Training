package Arrays.HomeWork;

import java.util.HashMap;
import java.util.Map;

public class _4Sum_II {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> m1 = getMap(nums1,nums2), m2 = getMap(nums3,nums4);
        int count = 0;
        for(int sum: m1.keySet()){
            int need= -sum;
            count+= m1.get(sum)*m2.getOrDefault(need,0);
        }
        return count;
    }
    static Map<Integer,Integer> getMap(int[] nums1,int[] nums2){
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums2.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum = nums1[i]+nums2[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        return map;
    }
}
