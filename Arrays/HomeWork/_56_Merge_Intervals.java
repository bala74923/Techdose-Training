package Arrays.HomeWork;
import java.util.*;
public class _56_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start = intervals[0][0], end = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for(int i=1 ;i< intervals.length ;i++){
            int curr_start = intervals[i][0];
            int curr_end = intervals[i][1];
            if( curr_start <= end){
                end = Math.max(curr_end, end);
            }else{
                res.add( new int[]{start, end});
                start = curr_start;
                end = curr_end ;
            }
        }
        res.add( new int[]{ start, end});

        int[][] ans = new int[res.size()][2];
        for(int i=0;i<res.size() ;i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
