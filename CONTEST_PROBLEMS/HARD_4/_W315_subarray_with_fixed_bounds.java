package CONTEST_PROBLEMS.HARD_4;

public class _W315_subarray_with_fixed_bounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res =0 ;
        int mini = -1,maxi=-1,start = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==minK) mini=  i;
            if(nums[i]==maxK) maxi = i;
            if(nums[i]<minK || nums[i]>maxK){
                mini=maxi=-1;
                start = i+1;
            }
            res+= Math.max(0L, Math.min(mini,maxi)-start+1);
        }
        return res;
    }
}
