package _5_Arrays.SlidingWindow.Variable_sized_slidingWindow;

import java.util.Scanner;
/*
https://www.geeksforgeeks.org/longest-subarray-sum-elements-atmost-k/?ref=lbp
 */
public class LargestSubarraySize_LT_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i]= sc.nextInt();
        int K = sc.nextInt();
        int prev = 0,end = 0;
        int res = 0,slidingWindowSum=0;
        while(end<N){
            slidingWindowSum+= arr[end];
            while(slidingWindowSum>K){
                slidingWindowSum-=arr[prev++];
            }
            res = Math.max(res,end-prev+1);
            end++;
            System.out.printf("prev =%d end = %d sum=%d\n",prev,end,slidingWindowSum);
        }
        System.out.println(res);
    }
}
