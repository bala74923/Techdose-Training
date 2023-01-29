package _4_Sorting_Algorithms.Lessons;

import java.util.*;

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
        List<Integer>[] hash = new ArrayList[bucketSize];
        for(int i=0;i<bucketSize;i++){
            hash[i]= new ArrayList<>();
        }
        for(int val:arr){
            int index = (val-min)/(int)load_factor;
            insert(hash[index],val);
        }
        int index=0;
        for(int i=0;i<bucketSize;i++){
            for(int val:hash[i]){
                arr[index++] = val;
            }
        }
    }
    static void insert(List<Integer> list,int element){
        list.add(element);
        int j = list.size()-1;
        while(j>0 && list.get(j-1)>list.get(j)) {
            swap(list, j, j - 1);
            j--;
        }
    }
    static void swap(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
}
