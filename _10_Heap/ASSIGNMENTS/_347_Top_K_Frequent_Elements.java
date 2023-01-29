package _10_Heap.ASSIGNMENTS;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _347_Top_K_Frequent_Elements {
    public int[] solve(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n: nums) map.put(n,map.getOrDefault(n,0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(int n:map.keySet()) pq.add(n);
        int[] res = new int[k];
        for(int i=0;i<k;i++) res[i] = pq.poll();
        return res;
    }
}
