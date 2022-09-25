package FREQUENT_QUESTIONS;

public class _72_merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tot = m+n;
        for(int i=0;i<n;i++)
            nums1[m+i]=  nums2[i];
        int gap = (tot>>1) + (tot&1);
        while(gap>=1){
            int i = 0,j = gap;
            while(j<tot){
                if(nums1[i]>nums1[j]){
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
                i++;
                j++;
            }
            if(gap==1)break;
            gap = (gap>>1) + (gap&1);
        }
    }
}
