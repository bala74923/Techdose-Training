package _5_Arrays.SlidingWindow.Fixed_sized_slidingWindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class SubArrrayMaximum {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0;i<N;i++)
            nums[i] = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[N-k+1];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<N;i++){
            if(!list.isEmpty() && list.peekFirst()==i-k) {
                list.pollFirst();
            }
            while(!list.isEmpty() && nums[list.peekLast()]<=nums[i]) {
                list.pollLast();
            }
            list.add(i);
            //System.out.println(list+", i = "+i);
            if(i>=k-1) arr[i-k+1] = nums[list.peekFirst()];
        }
        System.out.println(Arrays.toString(arr));
    }
}
