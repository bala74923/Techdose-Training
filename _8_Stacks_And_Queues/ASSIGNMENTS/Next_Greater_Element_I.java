package _8_Stacks_And_Queues.ASSIGNMENTS;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Next_Greater_Element_I {
    public static void main(String[] args) {

    }
    static int[] solve(int[] arr1,int[] arr2){
        int[] nge = ngeSequence(arr2);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr2.length;i++)
            map.put(arr2[i],i);
        int[] res=  new int[arr1.length];
        for(int i=0;i<arr1.length;i++){
            res[i] = nge[map.get(arr1[i])];
        }
        return res;
    }
    static int[] ngeSequence(int[] arr){
        Stack<Integer> st = new Stack<>();
        int N = arr.length;
        int[] res = new int[N];
        for(int i=N-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<arr[i])
                st.pop();
            res[i] = st.isEmpty()?-1:st.peek();
            st.push(arr[i]);
        }
        return res;
    }
}
