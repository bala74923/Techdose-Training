package _6_Matrix;

public class _378_Kth_Smallest_Element_in_a_Sorted_Matrix {
    int int_max = (int)1e9, int_min = (int)1e9;
    public int kthSmallest(int[][] matrix, int k) {
        int lo = int_max , hi = int_min;
        int R = matrix.length, C = matrix[0].length;
        for(int i=0;i<R ;i++){
            lo= Math.min(lo, matrix[i][0]);
            hi = Math.max(hi, matrix[i][C-1]);
        }

        int res = -1;
        while(lo<=hi){
            int mid = lo+ (hi-lo)/2;
            int now = countSmallEq(mid, matrix);
            if(now >=k){
                res = mid ;
                hi = mid-1;
            }else
                lo = mid+1;
        }
        return res;
    }
    int countSmallEq(int value, int[][] matrix){
        int res = 0;
        for(int row = 0; row<matrix.length ;row++){
            int lo = 0, hi = matrix[0].length-1;
            int last = -1;
            while( lo <= hi){
                int mid = lo + (hi-lo)/2;
                if( matrix[row][mid] <=value ){
                    last = mid ;
                    lo = mid+1;
                }
                else
                    hi = mid -1;
            }
            res =  res + last + 1 ;
        }
        return res;
    }
}
