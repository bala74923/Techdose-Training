package SORTING_ALGORITHMS_2;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {5,4,4,3,9,3,7,7,8,8,9,1,5,2};
        int[] newArr = sort(arr);
        System.out.println(Arrays.toString(newArr));
    }
    static int[] sort(int[] arr){
        int max = arr[0];
        for(int val:arr)
            max = Math.max(max,val);
        int digits = (int)(Math.log(max)/Math.log(10));
        for(int place = 0;place<=digits;place++){
            int[] hash = new int[10];
            //step 1
            for(int val:arr) {
                int ind = (val/(int)(Math.pow(10,place)))%10;
                hash[ind]++;
            }
            //step2
            for(int i=1;i<10;i++){
                hash[i]+=hash[i-1];
            }
            //step3
            int[] output = new int[arr.length];
            for(int i=arr.length-1;i>=0;i--){
                int ind = (arr[i]/(int)Math.pow(10,place))%10;
                output[--hash[ind]] = arr[i];
            }
            //assigning output to arr
            arr = output;
        }
        return arr;
    }
}
