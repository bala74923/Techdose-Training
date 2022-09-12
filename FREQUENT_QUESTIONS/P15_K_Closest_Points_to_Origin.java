package FREQUENT_QUESTIONS;

import java.util.PriorityQueue;

public class P15_K_Closest_Points_to_Origin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b)->
                        (int)(dist(a)-dist(b)) );
        for(int[] arr:points)
            pq.add(arr);
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
    static long dist(int[] val){
        return (long)(val[0]*val[0])+ (long)(val[1]*val[1]);
    }
}
