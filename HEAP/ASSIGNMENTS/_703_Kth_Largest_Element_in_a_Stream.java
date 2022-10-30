package HEAP.ASSIGNMENTS;

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int n: nums)
            pq.add(n);
        while(!pq.isEmpty() && pq.size()>k) pq.poll();
    }

    public int add(int val) {
        // if(pq.peek()>val){
        pq.add(val); // add new element if it is come on left side
        if(pq.size()>k)
            pq.poll();
        // }
        return pq.peek();
    }
}
