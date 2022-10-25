package STACKS_AND_QUEUES.CLASS_WORKS;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreaterElement {
    public static void main(String[] args) {
        int[] arr = {5,2,0,6,1,7};

        Stack<Integer> st= new Stack<>();
        int N= arr.length;

        int[] res = new int[N];
        for(int i=0;i<N;i++){
            while(!st.isEmpty() && st.peek()<=arr[i])
                st.pop();

            res[i] = st.isEmpty()?-1: st.peek();
            st.push(arr[i]);
        }
        System.out.println(Arrays.toString(res));
    }
}
