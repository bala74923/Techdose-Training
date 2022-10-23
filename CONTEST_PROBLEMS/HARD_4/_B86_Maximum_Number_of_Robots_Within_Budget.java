package CONTEST_PROBLEMS.HARD_4;

import java.util.Deque;
import java.util.LinkedList;

public class _B86_Maximum_Number_of_Robots_Within_Budget {
    public static void main(String[] args) {

    }
    static int solve(int[] charge,int[] running,long budget){
        long currsum = 0, currlength= 0 ;
        int res = 0;
        int N = charge.length;
        Deque<int[]> dq= new LinkedList<>();
        int start = 0,end = 0;
        while(end<N){
            //System.out.printf("ind=%d prev=%d currsum=%d len=%d dq =",end,start,currsum,currlength);
            //print(dq);
            currsum+= running[end];
            currlength++;
            while(!dq.isEmpty() && dq.peekLast()[0]<=charge[end])
                dq.pollLast();
            dq.add(new int[]{charge[end],end});

            while(!dq.isEmpty() && (currsum*currlength)+ dq.peekFirst()[0]>budget){
                //System.out.println((currsum*currlength)+ dq.peekFirst()[0]+" inside");
                currsum-=running[start];
                currlength--;
                if(!dq.isEmpty() && start>=dq.peekFirst()[1])
                    dq.pollFirst();
                start++;
            }

            res = Math.max(res,(int)currlength);
            end++;
        }
        return res;
    }
}
