package SORTING_ALGORITHMS.Lessons;

import java.util.Arrays;

public class Count_sort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,7,8,9,1,5,2};
        int[] newArr = countsort(arr);
        System.out.println(Arrays.toString(newArr));
    }
    static int[] countsort(int[] arr){
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        int[] hash = new int[max+1];
        for(int n:arr)
            hash[n]++;
        for(int i=1;i<=max;i++){
            hash[i]+=hash[i-1];
        }
        // from right to left
        System.out.println(Arrays.toString(hash));
        int[] outArray = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            outArray[--hash[arr[i]]] = arr[i];
        }
        return  outArray;
    }
}
