package FREQUENT_QUESTIONS;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P5_Merge_Intervals {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(arr);
        for(int[] res:result)
            System.out.println(Arrays.toString(res));
    }
    static int[][] merge(int[][] arr) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(arr,(a, b)->a[0]-b[0]);
        int start = arr[0][0],end = arr[0][1];
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]<=end){
                end=  Math.max(end,arr[i][1]);
            }
            else{
                list.add(new int[]{start,end});
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        list.add(new int[]{start,end});
        int[][] ans = new int[list.size()][2];
        for(int i=0;i<ans.length;i++)
            ans[i] = list.get(i);
        return ans;
    }
}
