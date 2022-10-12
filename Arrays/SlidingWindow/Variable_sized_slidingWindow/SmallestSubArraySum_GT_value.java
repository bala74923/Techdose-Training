package Arrays.SlidingWindow.Variable_sized_slidingWindow;

import java.util.Scanner;
/*
https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 */
public class SmallestSubArraySum_GT_value {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr= new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        int K = sc.nextInt();

        int slidingWindowSum= 0, res = Integer.MAX_VALUE;
        int pre = 0,end = 0;
        while(end<N){
            slidingWindowSum+= arr[end++];
            //System.out.println(slidingWindowSum+"=>"+end);
            while(slidingWindowSum>K){
                System.out.printf("pre=%d end = %d,res =%d,sum=%d\n",pre,end,res,slidingWindowSum);
                res = Math.min(res,end-pre+1);
                slidingWindowSum-=arr[pre++];
            }
            end++;
        }
        System.out.println(res);
    }
}
