package Arrays.HomeWork;
import java.util.*;
public class _4_Median_of_two_sorted_arrays {
    int int_min = -(int)1e9 ;
    int int_max = (int)1e9;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();

        l1.add(int_min);
        for(int i=0;i<nums1.length ;i++)
            l1.add(nums1[i]);
        l1.add(int_max);

        l2.add(int_min);
        for(int i=0;i<nums2.length; i++)
            l2.add(nums2[i]);
        l2.add(int_max);

        int m = nums1.length , n = nums2.length , mid_len =((m+n)/2)+((m+n)&1);
        int lo = Math.max(0,mid_len-n),hi = Math.min(mid_len,l1.size()-1) ;
        while(lo<=hi){
            int p1 = lo + (hi-lo)/2;
            int p2 = mid_len - p1 ;

            int p1_l = l1.get(p1),p2_l = l2.get(p2);
            int p1_r = l1.get(p1+1) ,  p2_r =l2.get(p2+1);
            if(p1_l <= p2_r && p2_l <= p1_r){
                // return answer
                if((m+n)%2==1){ // odd so one mid
                    return Math.max(p1_l,p2_l);
                }else{
                    return (Math.max(p1_l,p2_l) + Math.min(p1_r,p2_r))/2.0 ;
                }
            }
            else{
                if(p1_l >p2_r){
                    hi = p1 -1 ;
                }else lo = p1 +1;
            }
        }
        return -1;
    }
}
