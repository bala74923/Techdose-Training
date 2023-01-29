package _4_Sorting_Algorithms.Lessons;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4,2,1,3,7,5,6,9,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr){
        int N= arr.length;
        for(int index=0;index<N-1;index++){
            int minIndex = index;
            for(int j = index+1;j<N;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            swap(arr,minIndex,index);
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
/*
in sorted array
0 th index has minimum element in the array
1 th index has minimum element in the array except first element

process
========
find the element with min index after current ,swap with current index


find the minimum elements in the order so we can finally achieve the
sorted array in n-1 traversal
 */
