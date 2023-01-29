package _8_Stacks_And_Queues.CLASS_WORKS;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = {5,2,0,6,1,7};

        Stack<Integer> st= new Stack<>();
        int N= arr.length;

        int[] res = new int[N];
        for(int i=N-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>=arr[i])
                st.pop();

            res[i] = st.isEmpty()?-1: st.peek();
            st.push(arr[i]);
        }
        System.out.println(Arrays.toString(res));
    }
}
