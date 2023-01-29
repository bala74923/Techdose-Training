package _4_Sorting_Algorithms.Lessons;


import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,2,1,3,7,5,6,9,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr){
        int N= arr.length;

        for(int i=N-1;i>0;i--){
            boolean swapped = false;
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    swapped = true;
                }
            }
            if(!swapped)
                break;
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
/*
let assume array = [4,3,2,1]
bubble sort -> find the largest element every time by swap between pairs

if we found arrange elements in flow of n-1 to 1 then remaining
element at index 0 is defaultly arranged

so we run a loop i-> n-1 to 1
    each time we identify the larger element up to i,
    and fix that element at i th position

    as we are checking only up to i,
    j-> 0 to i-1 (because we are checking as pairs)

               every time we found elements arranged at wrong order we swap

 */
