package Arrays.HomeWork;

import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        gapAlgo(nums1,m,nums2,n);
    }
    void merge1(int[] nums1,int m,int[] nums2,int n){
        int[] arr = new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]) arr[k++]=nums1[i++];
            else arr[k++] = nums2[j++];
        }
        while(i<m) arr[k++] = nums1[i++];
        while(j<n) arr[k++] = nums2[j++];
        for(int ind=0;ind<m+n;ind++)
            nums1[ind] = arr[ind];
    }

    void merge2(int[] nums1,int m,int[] nums2,int n){
        // swap and insertion sort
        for(int i=0;i<m;i++){
            if(n>=1 && nums1[i]>nums2[0]){
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;

                int j = 0;
                while(j<n-1 && nums2[j]>nums2[j+1]){
                    temp = nums2[j];
                    nums2[j] = nums2[j+1];
                    nums2[j+1] = temp;
                    j++;
                }
            }
        }
        for(int j=0;j<n;j++){
            nums1[m+j] = nums2[j];
        }
    }
    void gapAlgo(int[] nums1,int m,int[] nums2,int n){
        for(int i=0;i<n;i++)
            nums1[i+m]= nums2[i];
        int gap = m+n;
        gap = (gap/2)+(gap%2);
        while(gap>=1){
            int i= 0, j= i+gap;
            while(j<m+n){
                if(nums1[i]>nums1[j]){
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
                i++;j++;
            }
            System.out.println(Arrays.toString(nums1));
            if(gap==1) break;
            gap = (gap/2)+(gap%2);
        }
    }
    /*
    gap algorithm runs on o(nlogn) time and o(1) space
    gap goes from length  of array(n) to 1 each time divisible by 2
    so it runs logn time for each time values are swapped
    so o(nlogn)

    arr1 = 1 4 5
    arr2 = 3 6
    assume this like  1 4 5  3 6

    gap = 5/2 +1 = 3
        one pointer at 0 th pos another in 3th pos
        [->1 4 5 ->3 6]   1<3 so skip
         [1 ->4 5 3 ->6] 4<6 so skip
         next iteration pointer on right goes outside boundary

    gap = 3/2 + 1 = 2
          one pointer at 0 th pos another in 2th pos
        [->1 4 ->5 3 6]   1<5 so skip
         [1 ->4 5 ->3 6] 4>3 so swap
         [1 3 ->5 4 ->6] 5<6 so skip
         next iteration pointer on right goes outside boundary
         
    gap = 2/2 = 1 (last iteration)
          one pointer at 0 th pos another in 1th pos
        [->1 ->3 5 4 6]   1<3 so skip
         [1 ->3 ->5 4 6] 3<5  so skip
         [1 3 ->5 ->4 ->6] 5>4  so swap
         [1 3 4 ->5 ->6] 5<5 so skip
         next iteration pointer on right goes outside boundary

    now merge is done
    [1,3,4,5,6]

     */
}
