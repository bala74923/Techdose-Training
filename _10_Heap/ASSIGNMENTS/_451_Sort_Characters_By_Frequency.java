package _10_Heap.ASSIGNMENTS;

import java.util.PriorityQueue;

public class _451_Sort_Characters_By_Frequency {
    public String frequencySort(String s) {
        int[] arr = new int[128];
        for(char c:s.toCharArray()) arr[c]++;
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b)->arr[b]==arr[a]?a-b:arr[b]-arr[a]);
        for(char c: s.toCharArray()) pq.add(c);
        StringBuilder sb = new StringBuilder("");
        while(!pq.isEmpty())
            sb.append(pq.poll());
        return sb.toString();
    }
}
