package CONTEST_PROBLEMS.HARD_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _B88_No_of_Pairs_Satisfy_inequality {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr1 = new int[n];
        for(int i=0;i<n;i++)  arr1[i] = sc.nextInt();

        int[] arr2 = new int[n];
        for(int i=0;i<n;i++)  arr2[i] = sc.nextInt();

        int diff = sc.nextInt();


    }
    static long solve(int[] arr1,int[] arr2,int diff){
        //TreeMap<Integer,Integer> mp = new TreeMap<>();
        int shift = 30000;
        BIT bit = new BIT(shift*2);
        long  res = 0;
        for(int i=0;i<arr1.length;i++){
            int curr = arr1[i]-arr2[i];
            //res+= count(mp,curr);
            res+= bit.query(curr+shift);
            bit.update(curr+shift-diff);
            //mp.put(value,mp.getOrDefault(value,0)+1);
        }
        return res;
    }

    // brute force o(N) so cannot use
    static int count(TreeMap<Integer,Integer> mp,int val){
        int res = 0;
        for(int key: mp.keySet()){
            if(key>val) return res;
            res+= mp.get(key);
        }
        return res;
    }
}
// both update and query takes place in o(log n) time
class BIT{
    int[] arr;
    BIT(int len){
        arr = new int[len+2];
    }
    public void update(int val){
        // node should be picked is val+1
        for(int i = val+1;i<arr.length;i+=(i&-i))
            arr[i]++;
    }
    public  int  query(int val){
        // should start from val+1 because range is (0,val)
        int sum = 0;
        for(int i=val+1;i>0;i-=(i&-i))
            sum+= arr[i];
        return sum;
    }
}
