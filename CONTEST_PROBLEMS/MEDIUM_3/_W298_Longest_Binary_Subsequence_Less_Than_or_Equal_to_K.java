package CONTEST_PROBLEMS.MEDIUM_3;

public class _W298_Longest_Binary_Subsequence_Less_Than_or_Equal_to_K {
    public int longestSubsequence(String s, int k) {
        int res = 0 ,N = s.length(),cost=1;
        for(int i = N-1;i>=0;i--){
            if(s.charAt(i)=='0'|| cost<=k){
                res++;
                k-= cost*(s.charAt(i)-'0');
            }if(cost<=k) cost*=2;
        }
        return res;
    }
}
