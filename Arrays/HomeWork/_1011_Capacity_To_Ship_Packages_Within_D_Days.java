package Arrays.HomeWork;

public class _1011_Capacity_To_Ship_Packages_Within_D_Days {
    int int_max = (int)1e9;
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0,hi = int_max;
        int  res = -1;
        while( lo<= hi){
            int mid = lo+ (hi-lo)/2;
            if( possible(mid,weights, days) ){
                res = mid ;
                hi = mid -1 ;
            }
            else
                lo = mid + 1;
        }
        return res;
    }
    boolean possible(int curr,int[] weights,int days){
        int now = curr;
        for(int i=0;i<weights.length ; i++){
            if(now<weights[i]){
                now = curr ;
                days--;
                if(days == 0) return false;
            }
            now = now - weights[i];
            if(now<0) return false;
        }
        return true;
    }
}
