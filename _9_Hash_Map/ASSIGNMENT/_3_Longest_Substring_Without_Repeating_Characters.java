package _9_Hash_Map.ASSIGNMENT;

public class _3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[128];
        int left=0,right =0;
        int res = 0;
        while(right<s.length()){
            while(arr[s.charAt(right)]>0){
                arr[s.charAt(left)]--;
                left++;
            }
            arr[s.charAt(right)]++;
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}
