package FREQUENT_QUESTIONS;

import java.util.Arrays;

public class P14_Product_of_Array_Except_Self {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
    static int[] productExceptSelf(int[] arr) {
        int N = arr.length;
        int[] ans = new int[N];
        int left =1;
        for(int i=0;i<N;i++){
            ans[i] = left;
            left*=arr[i];
        }
        int right = 1;
        for(int i=N-1;i>=0;i--){
            ans[i]*=right;
            right*=arr[i];
        }
        return ans;
    }
}
