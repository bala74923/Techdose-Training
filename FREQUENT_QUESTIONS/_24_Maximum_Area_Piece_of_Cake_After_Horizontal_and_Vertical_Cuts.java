package FREQUENT_QUESTIONS;

import java.util.Arrays;

public class _24_Maximum_Area_Piece_of_Cake_After_Horizontal_and_Vertical_Cuts {
    int mod = (int)1e9+7;
    public int maxArea(int h, int w, int[] harr, int[] varr) {
        return mul(get(harr,h),get(varr,w));
    }
    int mul(long a,long b){
        return (int)(((a%mod)*(b%mod))%mod);
    }
    long get(int[] arr,int N){
        Arrays.sort(arr);
        long max = 0;
        int prev=0;
        for(int i=0;i<=arr.length;i++){
            int curr=(i<arr.length)?arr[i]:N;
            max = Math.max(max,curr-prev);
            prev = curr;
        }
        return max;
    }
}
