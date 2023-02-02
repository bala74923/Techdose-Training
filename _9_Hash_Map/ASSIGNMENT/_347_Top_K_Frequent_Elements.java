package _9_Hash_Map.ASSIGNMENT;
import java.util.*;
public class _347_Top_K_Frequent_Elements {

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length ;i++)
            map.put(nums[i], map.getOrDefault(nums[i],0)+1 );



        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));

        for(int key: map.keySet()){
            pq.add(key);
            if(pq.size() >k)
                pq.poll();
        }

        int index = 0;
        while(index<k){
            res[k-index-1] = pq.poll();
            index++;
        }

        return res;
    }
}
