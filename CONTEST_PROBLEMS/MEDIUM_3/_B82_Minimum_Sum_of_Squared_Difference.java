package CONTEST_PROBLEMS.MEDIUM_3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _B82_Minimum_Sum_of_Squared_Difference {
    public static void main(String[] args) {

    }
    static long solve(int[] a1,int[] a2,int k1,int k2){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<a1.length;i++){
            pq.add(a1[i]-a2[i]);
        }
        int K = k1+k2;
        while(K-->0){
            int low = pq.poll();
            pq.add(low<0?++low:--low);
        }
        return sum(pq);
    }
    static long sum(PriorityQueue<Integer> pq){
        long res = 0;
        for(int val: pq) res+= val*val;
        return res;
    }
}
