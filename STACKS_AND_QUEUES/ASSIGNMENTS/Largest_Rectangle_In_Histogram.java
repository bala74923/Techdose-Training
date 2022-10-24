package STACKS_AND_QUEUES.ASSIGNMENTS;

import java.util.Stack;

public class Largest_Rectangle_In_Histogram {
    // tc-> o(n+n)
    // sc-> o(n)
    static int solve(int[] arr){
        int N = arr.length;
        int[] res = new int[N];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<N;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            res[i] =st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        int max = 0;
        for(int i=N-1;i>=0;i--){
            while(!st.isEmpty()&& arr[st.peek()]>=arr[i])
                st.pop();
            int curr= st.isEmpty()?N: st.peek();
            // curr- is smaller excact position for end is curr-1
            // res[i] is smaller than arr[i] , position for start is res[i]+1
            // these two are like low,hi now calculate range (hi-low+1)
            int length = (curr-1)-(res[i]+1)+1;
            max = Math.max(max,length*arr[i]);
            st.push(i);
        }
        return max;
    }

}
