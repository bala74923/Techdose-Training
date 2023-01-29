package _10_Heap.ASSIGNMENTS;

import java.util.Deque;
import java.util.LinkedList;

public class _239_Sliding_Window_Maximum {
    static int[] solve(int[] arr,int k){
        int N = arr.length;
        Deque<Integer> dq = new LinkedList<>();
        int possible = N-k+1;
        int[] res = new int[possible];

        for(int i=0;i<arr.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()==i-k) dq.pollFirst();
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i])
                dq.pollLast();
            dq.add(i);
            if(i+1>=k) res[i-k+1] = arr[dq.peekFirst()];
        }


        return res;
    }
}
