package CONTEST_PROBLEMS.MEDIUM_3;

import java.util.Arrays;

public class _B78_Maximum_White_Tiles_Covered_by_a_Carpet {
    static int solve(int[][] carpets,int len){
        Arrays.sort(carpets,(a,b)->a[0]-b[0]);
        int res = 0, N = carpets.length;
        int left = 0,right = 0,cover = 0;
        while(right<N && res<len){ // res<len as we know that res cannot exceed len
            //can be fully covered, carpets[left][0]+len -> maximum point
            // if current carpent is less than max point extend it
            if(carpets[right][1] < carpets[left][0]+len){
                cover+= carpets[right][1]-carpets[right][0]+1;
                res = Math.max(res,cover);
                right++;
            }else{ // partially cover
                res = Math.max(res,cover+ carpets[left][0]+len-carpets[right][0]);
                cover-=(carpets[left][1]-carpets[left][0]+1);
                left++;
            }
        }
        return res;
    }
}
