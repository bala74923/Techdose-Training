package SORTING_ALGORITHMS.Lessons;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4,2,1,3,7,5,6,9,4};
        List<Integer> list=  new ArrayList<>();
        for(int n:arr){
            insert(list,n);
        }
        System.out.println(list);
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
