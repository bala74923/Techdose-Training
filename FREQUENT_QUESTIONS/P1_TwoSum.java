package FREQUENT_QUESTIONS;

import java.util.HashMap;
import java.util.Map;

public class P1_TwoSum {
    public static void main(String[] args) {

    }
    static int[] bruteForce(int[] arr,int K){ //o(n^2)
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==K)
                    return new int[]{i,j};
            }
        }
        return null;
    }
    static int[] approach(int[] arr,int K){ //o(n)
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int need = K-arr[i];
            if(map.get(need)!=null)
                return new int[]{map.get(need),i};
            map.put(arr[i],i);
        }
        return null;
    }
}
