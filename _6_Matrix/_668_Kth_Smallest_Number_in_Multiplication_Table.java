package _6_Matrix;

public class _668_Kth_Smallest_Number_in_Multiplication_Table {
    public int findKthNumber(int m, int n, int k) {
        int lo = 0,hi = m*n ;
        int res = -1;
        while( lo<=hi){
            int mid = lo+(hi-lo)/2;
            int small_eq = countSmallEq(mid, m ,n );
            if(small_eq>=k){
                res = mid ;
                hi = mid - 1;
            }else lo = mid +1 ;
        }
        return res;
    }
    int countSmallEq(int value,int m,int n){
        int res = 0;
        for(int row = 1; row<=m ;row++){
            int last = Math.min( value/row ,n);
            res = res + last ;
        }
        return res;
    }
}
