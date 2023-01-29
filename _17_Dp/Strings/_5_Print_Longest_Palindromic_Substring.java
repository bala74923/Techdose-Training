package _17_Dp.Strings;

public class _5_Print_Longest_Palindromic_Substring {
    // solution with 2 pointers
    class Solution1 {
        int start_ind = -1, max_len = 0;
        public String longestPalindrome(String s) {
            // for every index calculate the longest palindromic substring
            start_ind =  max_len = 0;
            for(int i=0;i<s.length();i++){
                calc(i,i,s);
                calc(i,i+1,s);
            }
            //System.out.println(max_len);
            return s.substring(start_ind, start_ind+max_len);
        }
        void calc(int left,int right, String s){
            int len=0;
            while(left>=0  && right<s.length() && s.charAt(left) == s.charAt(right)){
                len = right-left+1;
                if(max_len < len){
                    max_len = len;
                    start_ind = left;
                }
                left--;
                right++;
            }
        }
    }
    // solution with dp approach (dp on sliding window)
    public String longestPalindrome(String s) {
        int N = s.length();
        boolean[][] dp =  new boolean[N+1][N+1];
        for(int i = 0;i<N;i++){
            dp[i][i] = true;
        }
        int max_len = 0, max_i = 0, max_j = 0;
        // i goes from 1 to N, j goes from N to i+1
        for(int i=N;i>=1;i--){
            // i==j already this case has been seen
            for(int j=i+1;j<=N;j++){
                if(s.charAt(i-1) == s.charAt(j-1) && (j-i<=2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                }
                if(j-i+1 > max_len && dp[i][j]){
                    max_len = j-i+1;
                    max_i = i-1;max_j = j-1;
                }
            }
        }
        return s.substring(max_i,max_j+1);
    }
}
