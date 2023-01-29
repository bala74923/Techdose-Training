package _4_Sorting_Algorithms.Assignments;

import java.util.Random;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quicksort(nums,0,n-1);
        return nums;
    }
    static void quicksort(int[] arr,int lo,int hi){
        if(lo<hi){
            int part = partite(arr,lo,hi);
            quicksort(arr,lo,part-1);
            quicksort(arr,part+1,hi);
        }
    }
    static int partite(int[] arr,int lo,int hi){

        random(arr,lo,hi);
        int i = lo-1,pivot= arr[hi];
        for(int j=lo;j<hi;j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,hi);
        return i+1;
    }
    static void random(int[] arr,int lo,int hi){
        Random rand = new Random();
        int pivot = rand.nextInt(hi-lo) + lo;
        int temp= arr[hi];
        arr[hi] = arr[pivot];
        arr[pivot] = temp;
    }
    static void swap(int[] arr,int i,int j){
        int temp  =arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
