package Arrays.ClassWork;

import java.util.Random;

public class QuickSelect {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return sort(nums,0,n-1,n-k);
    }
    int sort(int[] nums,int lo,int hi,int pos){
        if(lo<hi){
            int part = partite(nums,lo,hi);
            if(pos<part) return sort(nums,lo,part-1,pos);
            if(pos==part) return nums[part];
            return sort(nums,part+1,hi,pos);
        }
        return nums[lo];
    }
    int partite(int[] arr,int lo,int hi){
        randy(arr,lo,hi);
        int pivot = hi, i = lo-1;
        for(int j=lo;j<hi;j++){
            if(arr[j]<=arr[pivot]){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,pivot);
        return i+1;
    }
    void randy(int[] arr,int lo,int hi){
        Random rand = new Random();
        int pivot = rand.nextInt(hi-lo)+lo;
        swap(arr,pivot,hi-1);
    }
    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
