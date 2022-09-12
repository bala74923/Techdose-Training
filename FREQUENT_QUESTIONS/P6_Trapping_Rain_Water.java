package FREQUENT_QUESTIONS;

import java.util.Arrays;

public class P6_Trapping_Rain_Water {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] level = new int[n];
        int max = 0;
        for(int i=0;i<arr.length;i++){
            level[i]=max;
            max = Math.max(max,arr[i]);
        }
        max = 0;
        for(int i=arr.length-1;i>=0;i--){
            level[i] = Math.min(level[i],max);
            max = Math.max(max,arr[i]);
        }
        int stored = 0;
        System.out.println(Arrays.toString(level));
        for(int i=0;i<arr.length;i++){
            stored+= Math.max(level[i]-arr[i],0);
        }
        return stored;
    }
}
