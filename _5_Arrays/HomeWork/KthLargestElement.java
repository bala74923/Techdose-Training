package _5_Arrays.HomeWork;

import java.util.Random;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int pos = nums.length-k;
        return quickSelect(nums,pos,0,nums.length-1);
    }
    int quickSelect(int[] nums,int pos,int lo,int hi){
        if(lo<hi){
            int part = partite(nums,lo,hi);
            if(part==pos) return nums[pos];
            if(part>pos) return quickSelect(nums,pos,lo,part-1);
            return quickSelect(nums,pos,part+1,hi);
        }
        return nums[lo];
    }
    void random(int[] nums,int lo,int hi){
        Random rand = new Random();
        int pivot = lo+rand.nextInt(hi-lo);
        swap(nums,hi,pivot);
    }
    int partite(int[] nums,int lo,int hi){
        random(nums,lo,hi);
        int i = lo-1,pivot = hi;
        for(int j=lo;j<hi;j++){
            if(nums[j]<=nums[pivot]){
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,pivot);
        return i+1;
    }
    void swap(int[] arr,int i,int j){
        int temp= arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
