package Arrays.HomeWork;

import java.util.*;

public class _862_Shortest_Subarray_with_Sum_at_Least_K {
    int int_max = (int)1e9;
    public int shortestSubarray(int[] nums, int k) {
        Stack<Integer> st  = new Stack<>();
        int sum = 0 , res = int_max;
        for(int ind = 0; ind< nums.length ;ind++){
            sum = sum + nums[ind];
            int need = k - sum ;
            while(!st.isEmpty() && st.peek()>=sum)
                st.pop() ;
            st.push( sum );
        }
        return res == int_max?-1: res;
    }
}
