package _5_Arrays.HomeWork;

public class _42_Trapping_Rain_Water {
    public int trap(int[] height) {
        int  N = height.length ;
        int[] left_max = new int[N];
        int curr_left_max = 0;
        for(int i = 0; i< N ; i++){
            left_max[i]  = curr_left_max;
            curr_left_max = Math.max( curr_left_max , height[i]);
        }

        int curr_right_max = 0;
        int[] right_max = new int[N];
        for( int i=N-1; i>=0 ;i--){
            right_max[i] = curr_right_max ;
            curr_right_max = Math.max(curr_right_max ,height[i]);
        }
        int res = 0;
        for(int i= 0; i< N; i++){
            int min = Math.min(left_max[i],right_max[i]);
            res =  res + Math.max( min -height[i], 0 );
        }
        return res;
    }
}
