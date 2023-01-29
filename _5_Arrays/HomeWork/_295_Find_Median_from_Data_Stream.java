package _5_Arrays.HomeWork;
import java.util.*;
public class _295_Find_Median_from_Data_Stream {


    class MedianFinder {
        PriorityQueue<Integer> first,second;
        public MedianFinder() {
            first = new PriorityQueue<>((a,b)->b-a);
            second = new PriorityQueue<>((a,b)->a-b);
        }

        public void addNum(int num) {
            first.add(num);
            second.add(first.poll());
            if(first.size() < second.size())
                first.add(second.poll());
        }

        public double findMedian() {
            if((first.size()+second.size())%2==0){
                return (first.peek()+second.peek())/2.0;
            }
            return first.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


}
