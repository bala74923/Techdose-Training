package SORTING_ALGORITHMS.Lessons;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {0,4,2,1,3,7,5,6,9,4,10};
        int N =arr.length;
        mergeSort(arr,0,N-1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int[] arr,int lo,int hi){
        if(lo<hi){
            int mid= lo+ (hi-lo)/2; // or (lo+hi)>>1 this cause overflow
            mergeSort(arr,lo,mid);
            mergeSort(arr,mid+1,hi);
            merge(arr,lo,mid,hi);
        }
    }
    static void merge(int[] arr,int lo,int mid,int hi){
        int[] use = new int[hi+1];
        int index=  lo, i=lo, j=mid+1;
        while(i<=mid && j<=hi){
            if(arr[i]<arr[j])
                use[index++] =arr[i++];
            else
                use[index++] = arr[j++];
        }
        while(i<=mid)
            use[index++] = arr[i++];
        while(j<=hi)
            use[index++] = arr[j++];

        for(int ind=lo;ind<=hi;ind++) {
            arr[ind] = use[ind];
        }
    }
}
/*
this algorithm works on divide and conquer basis
it will divide the array into subarrays till it reaches sub array size as 1
size 1 arrays are always sorted

divide the array into subarrays and merge the sorted subarrays
recursively to get sorted array

 */
