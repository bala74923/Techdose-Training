package SORTING_ALGORITHMS.Lessons;

import java.util.Arrays;

public class Quick_Sort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,7,8,9,1,5,2};
        quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quicksort(int[] arr,int lo,int hi){
        if(lo<hi){
            int partition = partite(arr,lo,hi);
            quicksort(arr,lo,partition-1);
            quicksort(arr,partition+1,hi);
        }
    }
    static int partite(int[] arr,int lo,int hi){
        int i = lo-1, pivot=arr[hi];
        for(int j=lo;j<hi;j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,hi);
        return i+1;
    }
    static void swap(int[] arr,int i,int j){
        int temp  = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
