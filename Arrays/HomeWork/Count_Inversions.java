package Arrays.HomeWork;
import java.util.*;
public class Count_Inversions {
    // gfg problem link -> https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    static long inversionCount(long arr[], long N)
    {
        new_arr= new long[(int)N];
        // Your Code Here
        return mergeSort(arr, 0, N-1);

    }
    static long mergeSort(long[] arr,long start,long end){
        // if start> end not possible
        // if start == end , no inversion occur on array of length 1
        if( start < end){
            long mid = start + (end-start)/2;
            long left_count  = mergeSort(arr, start, mid);
            long right_count =  mergeSort(arr, mid+1, end);
            long curr_count  = merge(arr, start, mid,end) ;
            return left_count + curr_count + right_count;
        }
        return 0;
    }
    static long[] new_arr ;
    static long merge(long[] arr,long start,long mid,long end){


        long inversions = 0;

        int i = (int)start, j = (int)mid+1 ,k = (int)start ;

        while( i<= mid && j<= end){
            if(arr[i]<=arr[j]){
                new_arr[k++] = arr[i++];
            }else{
                new_arr[k++] = arr[j++] ;
                long rem_elements = mid-i+1;
                inversions = inversions + rem_elements ;
            }
        }
        while(i<=mid){
            new_arr[k++] = arr[i++];
        }
        while(j<=end){
            new_arr[k++] = arr[j++];
        }
        for(int i1 = (int)start ; i1<=end; i1++ ){
            arr[i1] = new_arr[i1];
        }
        return  inversions ;
    }
}
