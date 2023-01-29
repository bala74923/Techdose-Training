package Arrays.HomeWork;
import java.util.* ;
public class _907_Sum_of_Subarray_Minimums {
    int mod = (int)(1e9+ 7) ;
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int N = arr.length ;

        int[] left_small = new int[N] , right_small = new int[N] ;
        // find prev smaller
        for(int i = 0;i<N; i++){
            while(!st.isEmpty() && arr[st.peek()] >=arr[i] )
                st.pop();
            left_small[i] = st.isEmpty()?-1: st.peek();
            st.add(i);
        }
        st.clear();
        // find next smaller
        for(int i = N-1;i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >arr[i] )
                st.pop();
            right_small[i] = st.isEmpty()?N: st.peek();
            st.add(i);
        }
        long res = 0 ;

        for(int i= 0;i<N ;i++){
            int left = left_small[i], right = right_small[i] ;
            int elements_on_left = i-left, elements_on_right = right-i;
            res = add(res , mul(
                            mul(elements_on_left, elements_on_right),arr[i]
                    )
            );
        }

        return (int)res ;
    }
    long add(long a,long b){
        return ((a%mod) + (b%mod))%mod;
    }
    long mul(long a,long b){
        return ((a%mod)*(b%mod))%mod ;
    }
}
