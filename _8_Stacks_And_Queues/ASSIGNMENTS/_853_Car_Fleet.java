package _8_Stacks_And_Queues.ASSIGNMENTS;
import java.util.*;
public class _853_Car_Fleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length ;
        int[][] arr = new int[N][2];
        for(int i=0; i<N ;i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a,b)->b[0]-a[0]);
        Stack<Float> st = new Stack<>();
        for(int i=0;i<N;i++){
            float time = (target-arr[i][0]) / (float)arr[i][1];
            if(!st.isEmpty() && st.peek()>=time)
                continue;
            else
                st.add(time);
        }
        return st.size();
    }
}
