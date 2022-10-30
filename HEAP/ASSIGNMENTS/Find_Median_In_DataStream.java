package HEAP.ASSIGNMENTS;

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> large,small;
    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a,b)->b-a);
    }

    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());
        if(small.size()>large.size())
            large.add(small.poll());
    }

    public double findMedian() {
        return (large.size()+small.size())%2==0?
                (large.peek()+small.peek())/2.0: large.peek();
    }
}
