package _5_Arrays.SlidingWindow.Variable_sized_slidingWindow;

import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String val = sc.next();
        System.out.println(solve(val));
    }
    static int solve(String s){ //o(n) -> alpha array
        char[] arr = s.toCharArray();
        int[] alpha = new int[128];
        int res = 0 , pre = 0,curr = 0;
        while(curr<arr.length){
            alpha[arr[curr]]++;
            while(alpha[arr[curr]]>1){
                alpha[arr[pre]]--;
                pre++;
            }
            res = Math.max(res,curr-pre+1);
            curr++;
        }
        return res;
    }
    // only for lower case only or uppercase only type constraints
    static int solveWithBitManipulation(String s){
        int map = 0;// 0 0 0 0 -> 32 0's
        int res = 0 , curr = 0, pre =0;
        while(curr<s.length()){
            while(contains(map,s.charAt(curr))){
                map = remove(map,s.charAt(pre));
                pre++;
            }
            map = add(map,s.charAt(curr));
            res = Math.max(res,curr-pre+1);
            curr++;
        }
        return res;
    }
    static boolean contains(int map,char c){
        return (map&(1<<(c-'a')))!=0;
    }
    static int add(int map,char c){
        return map|(1<<(c-'a'));
    }
    static int remove(int map,char c){
        return map & (~(1<<(c-'a')));
    }
}
