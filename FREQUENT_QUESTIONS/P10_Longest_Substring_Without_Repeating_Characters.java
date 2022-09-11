package FREQUENT_QUESTIONS;

public class P10_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    static int lengthOfLongestSubstring(String s) {
        int max = 0, prev=0 ,ind=0;
        int[] arr = new int[128];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)]++;
            while(arr[s.charAt(i)]>1)
                arr[s.charAt(prev++)]--;
            max = Math.max(max,i-prev+1);
        }
        return max;
    }
}
