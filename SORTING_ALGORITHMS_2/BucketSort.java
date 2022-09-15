package SORTING_ALGORITHMS_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {2,5,4,3,5,7,9,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr){
        int min= arr[0],max =arr[0];
        for(int i=1;i<arr.length;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        int range = (max-min+1);
        double load_factor  = 3.0;
        int bucketSize = (int)Math.ceil(range/load_factor);
        Queue<Integer>[] hash = new LinkedList[bucketSize];
        for(int i=0;i<bucketSize;i++){
            hash[i]= new LinkedList<>();
        }
        for(int val:arr){
            int index = (val-min)/(int)load_factor;
            hash[index].add(val);
        }
        int index=0;
        for(int i=0;i<bucketSize;i++){
            while(!hash[i].isEmpty()){
                arr[index++] = hash[i].poll();
            }
        }
    }
}
