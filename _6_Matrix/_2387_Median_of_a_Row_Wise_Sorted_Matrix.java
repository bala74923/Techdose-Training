package _6_Matrix;

public class _2387_Median_of_a_Row_Wise_Sorted_Matrix {
    public int matrixMedian(int[][] grid) {
        // a number is median if it has exactly n/2 elements as smaller than it
        int R = grid.length, C = grid[0].length ;
        int lo = 0,hi = (int)1e9, need = ((R*C)>>1)+1;
        int res = -1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            int small_elements_count = countSmallEq(mid, grid);
            if( small_elements_count >= need){
                res = mid;
                hi = mid -1;
            }else lo = mid + 1;
        }
        return res;
    }

    int countSmallEq(int val,int[][] grid){
        int res = 0;
        for(int row=0; row<grid.length ; row++){
            int lo = 0, hi = grid[0].length -1;
            int last_smaller = -1;
            while(lo<=hi){
                int mid = lo+(hi-lo)/2;
                if(grid[row][mid] <=val ){
                    last_smaller = mid;
                    lo = mid +1;
                }else hi = mid-1;
            }
            res=  res+ last_smaller+1 ;
        }
        return res;
    }
}
