package FREQUENT_QUESTIONS;

public class _48_search_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while(lo<=hi){
            int mid = (lo+hi)>>1;
            if(nums[mid]==target)
                return mid;
            //if left sorted
            if(nums[lo]<=nums[mid]){
                if(nums[lo]<= target && target<=nums[mid]){
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }
            }
            // if right sorted
            else{
                if(nums[mid]<=target && target<=nums[hi]){
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }
        }
        return -1;
    }
}
