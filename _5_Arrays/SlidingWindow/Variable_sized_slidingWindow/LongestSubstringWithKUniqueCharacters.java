package _5_Arrays.SlidingWindow.Variable_sized_slidingWindow;

import java.util.Scanner;
// https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
public class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        int K = sc.nextInt();

        int curr = 0,prev = 0, count= 0, res = -1;
        int[] map = new int[26];
        int N = arr.length;
        while(curr<N){
            // adding new element first time
            if(map[arr[curr]-'a']==0) count++;
            map[arr[curr]-'a']++;

            //removing extra elements
            while(count>K){
                map[arr[prev]-'a']--;
                if(map[arr[prev]-'a']==0)
                    count--;
                prev++;
            }
            if(count==K) res = Math.max(res,curr-prev+1);
            curr++;
        }
        System.out.println(res);
    }
}
