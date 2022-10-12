package Arrays.SlidingWindow.Fixed_sized_slidingWindow;

import java.util.*;

public class MaximumOfMinimumEveryWindowSizeK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        optimise(arr);
    }
    static void optimise(int[] arr){
        int N = arr.length;
        int[] nextSmaller= new int[N] , prevSmaller = new int[N] , res = new int[N];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(res,Integer.MIN_VALUE);
        // prev smaller
        for(int index=0;index<N;index++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[index]) st.pop();
            prevSmaller[index] = st.isEmpty()?-1: st.peek();
            st.push(index);
        }
        st.clear();
        //next smaller
        for(int index = N-1;index>=0;index--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[index]) st.pop();
            nextSmaller[index] = st.isEmpty()?N: st.peek();
            st.push(index);
        }
        System.out.println(Arrays.toString(prevSmaller));
        System.out.println(Arrays.toString(nextSmaller));
        for(int index=0;index<N;index++){
            int dist = nextSmaller[index]-prevSmaller[index]-1;
            for(int currLen=0;currLen<dist;currLen++) {
                res[currLen] = Math.max(res[currLen],arr[index] );
            }
        }
        System.out.println(Arrays.toString(res));
    }
    static void bruteForce(int[] arr){
        int N = arr.length;
        for(int len=1;len<=N;len++){
            System.out.println(solve(arr,N,len));
        }
        //System.out.println(Arrays.toString(arr));
    }
    static int solve(int[] arr,int n,int K){
        int max = Integer.MIN_VALUE;
        Deque<Integer> dq = new LinkedList<>();
        for (int i=0;i<n;i++){
            //remove window outer element
            while(!dq.isEmpty() && dq.peekFirst()==i-K)
                dq.pollFirst();
            // add element
            while(!dq.isEmpty() && arr[dq.peekLast()]>=arr[i])
                dq.pollLast();
            dq.add(i);
            // get answer
            if(i>=K-1) max = Math.max(max,arr[dq.peekFirst()]);
        }
        return max;
    }
}
