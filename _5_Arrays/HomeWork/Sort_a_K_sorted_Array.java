package _5_Arrays.HomeWork;

/*
nlogk -> asked method

gfg practice: https://practice.geeksforgeeks.org/problems/nearly-sorted-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article


 */
import java.util.* ;
public class Sort_a_K_sorted_Array {
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i= 0 ;i<arr.length ;i++){
            if(i>k){
                res.add(pq.poll());
            }
            pq.add(arr[i]);
        }
        while(!pq.isEmpty())
            res.add(pq.poll());
        return res;
    }
}
