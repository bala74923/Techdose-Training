package Arrays.SlidingWindow.Fixed_sized_slidingWindow;

import java.util.*;

public class FirstNegativeInEveryWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K= sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        int resIndex = 0;
        Deque<Integer> dq = new LinkedList<>();
        int[] res= new int[N-K+1];
        for(int i=0;i<N;i++){
            if(!dq.isEmpty() && dq.peekFirst()==i-K)
                dq.pollFirst();
            if(arr[i]<0)
                dq.add(i);
            if(i>=K-1)
                res[resIndex++] = dq.isEmpty()?0:arr[dq.peekFirst()];
        }
        System.out.println(Arrays.toString(res));
    }
}
