package _5_Arrays.HomeWork;
import java.util.*;
public class _88_Merge_Sorted_Array {
    /*
    gap algorithm works for array like
    [0,1,.. m-1,0,0,0,0],[0,..,n-1]
    which has extra space in array 1 (Leetcode 88)

    for input like [0....m -1][ 0...n-1]
     */
    public static void merge(long arr1[], long arr2[], int n, int m)
    {
        // code here
        int i = 0, j = 0, k = n-1 ;
        while( i<=k && j<m ){
            if(arr1[i]>arr2[j]){// i is big so swap
                long temp  =arr1[k];
                arr1[k] = arr2[j];
                arr2[j] = temp ;
                j++ ; k-- ;
            }else{
                i++ ;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
