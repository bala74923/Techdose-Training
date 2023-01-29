package Arrays.HomeWork;

public class _33_Search_in_Rotated_Sorted_Array {
    public int search(int[] arr, int target) {
        int lo = 0, hi = arr.length-1;
        while( lo<= hi ){
            int mid = lo+ (hi-lo)/2;
            if(arr[mid] ==  target)
                return mid ;

            if( arr[lo]<=arr[mid] ){
                // if present check
                if( arr[lo]<= target && target<=arr[mid])
                    hi = mid-1;
                else
                    lo = mid+1;

            }else{
                if( arr[mid]<= target && target<=arr[hi])
                    lo = mid+1;
                else
                    hi = mid-1;
            }
        }
        return -1;
    }
}
