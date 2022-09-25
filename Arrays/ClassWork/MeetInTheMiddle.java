package Arrays.ClassWork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
given set of N integers (N<=40)
and each value v (v<=10 ^9)
Determine the maximum sum subset having sum<=s (where s<=
 */
public class MeetInTheMiddle {
    public static void main(String[] args) {
        int[] arr = {5,3,-1,7};
        int s = 13;
        System.out.println(meetInTheMiddle(arr,s));
    }
    static int meetInTheMiddle(int[] arr,int s){
        int N = arr.length , mid = N/2;
        System.out.println(mid);

        List<Integer> l1 = getPowerSetInRange(arr,0,mid-1);
        List<Integer> l2 = getPowerSetInRange(arr,mid,N-1);
        Collections.sort(l2);
        int max = 0;
        for(int val: l1){
            int need  = s-val, index = LowerBound(l2,need);
            if(index!=-1) max = Math.max(max,val+l2.get(index));
        }
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(max);
        return max;
    }
    static int LowerBound(List<Integer> list,int key){
        int lo = 0,hi = list.size()-1;
        while(lo<=hi){
            int mid= lo+ (hi-lo)/2;
            if(list.get(mid)==key) return mid;
            if(list.get(mid)<key) lo = mid+1;
            else hi = mid-1;
        }
        return hi;
    }
    static List<Integer> getPowerSetInRange(int[] arr, int lo, int hi){
        List<Integer> list = new ArrayList<>();
        int range  = hi-lo+1;
        for(int i=0;i<(1<<range);i++){
            int sum = 0;
            for(int j=0;j<range;j++){
                if((i&(1<<j))!=0){
                    int index= j+lo;
                    sum+= arr[index];
                }
            }
            list.add(sum);
        }
        return list;
    }
    static int bruteForce(int[] arr,int s){
        int max=  0 , len = arr.length;
        for(int i=0;i<(1<<len);i++){
            int sum = 0;
            for(int j=0;j<len;j++){
                if((i&(1<<j))!=0){
                    sum+= arr[j];
                }
            }
            if(sum<=s)
                max= Math.max(max,sum);
        }
        return max;
    }
}
