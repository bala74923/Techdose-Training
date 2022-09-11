package FREQUENT_QUESTIONS;

public class P7_Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
    static  int maxProfit(int[] arr) {
        int res = 0,n=arr.length,max=arr[n-1];
        for(int i=n-2;i>=0;i--){
            res= Math.max(max-arr[i],res);
            max = Math.max(max,arr[i]);
        }
        return res;
    }
}
