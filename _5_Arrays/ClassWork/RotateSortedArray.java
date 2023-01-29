package _5_Arrays.ClassWork;

public class RotateSortedArray {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while(lo<=hi){
            int mid = lo+ (hi-lo)/2;
            //System.out.println(lo+","+hi);
            if(nums[mid]==target) return mid;
            if(nums[lo]<=nums[mid]){ //left sorted
                if(nums[lo]<=target && target<=nums[mid]) hi = mid;
                else lo = mid+1;
            }else{
                if(nums[mid]<=target && target<=nums[hi]) lo = mid+1;
                else hi= mid;
            }
        }
        return -1;
    }
}
