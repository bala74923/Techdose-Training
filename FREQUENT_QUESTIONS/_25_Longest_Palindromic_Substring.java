package FREQUENT_QUESTIONS;

public class _25_Longest_Palindromic_Substring {
    int start,len;
    public String longestPalindrome(String s) {
        start=len=0;
        for(int i=0;i<s.length();i++){
            extend(s,i,i+1);
            extend(s,i,i);
        }
        return s.substring(start,start+len);
    }
    void extend(String s,int i,int j){
        while(i>-1 && j<s.length() && s.charAt(i)==s.charAt(j)){
            int currLen = j-i+1;
            if(len<currLen){
                len = currLen;
                start = i;
            }
            i--;j++;
        }
    }

}
