package CONTEST_PROBLEMS.MEDIUM_3;

import java.util.Arrays;

public class _W294_MinimumLinestoRepresentaLineChart {
    int solve(int[][] stocks){
        int N = stocks.length;
        if(N==1) return 0; // it is a point not a line
        int res =1 ;
        Arrays.sort(stocks,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        for(int i=2;i<N;i++){
            long x1 = stocks[i-2][0], x2 = stocks[i-1][0], x3 = stocks[i][0];
            long y1 = stocks[i-2][1], y2 = stocks[i-1][1], y3 =  stocks[i][1];
            long s1 = (x1-x2)*(y3-y2);
            long s2 = (y1-y2)*(x3-x2);
            if(s1!=s2) res++;
        }
        return res;
    }

}
