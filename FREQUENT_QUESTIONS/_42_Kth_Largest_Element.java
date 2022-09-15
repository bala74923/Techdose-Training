package FREQUENT_QUESTIONS;

import java.util.Random;

public class _42_Kth_Largest_Element {
    public int findKthLargest(int[] nums, int k) {
        return find(nums,0,nums.length-1,nums.length-k);
    }
    int find(int[] nums,int lo,int hi,int index){
        if(lo<hi){
            int part = partite(nums,lo,hi);
            if(part==index) return nums[index];
            else if(index<part) return find(nums,lo,part-1,index);
            return find(nums,part+1,hi,index);
        }
        return nums[lo];
    }
    int partite(int[] arr,int lo,int hi){
        random(arr,lo,hi);

        int i = lo-1, pivot = arr[hi];
        for(int j=lo;j<hi;j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,hi);
        return i+1;
    }
    void random(int[] arr,int lo,int hi){
        Random rand = new Random();
        int piv = rand.nextInt(hi-lo)+lo;
        int temp  =arr[piv];
        arr[piv] = arr[hi];
        arr[hi] = temp;
    }
    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
