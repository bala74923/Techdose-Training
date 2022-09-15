package FREQUENT_QUESTIONS;

public class _29_Decode_Ways {
    public int numDecodings(String s) {
        int N = s.length();
        int prev1=1,prev2=1;
        for(int index=N-1;index>=0;index--){
            int one = 0,two=0;
            if(s.charAt(index)!='0'){
                one = prev1;
                if(index+1<s.length() && getVal(s,index,index+1)<27)
                    two = prev2;
            }
            int curr = one+two;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    int getVal(String s,int i,int j){
        return (s.charAt(i)-'0')*10 + (s.charAt(j)-'0');
    }
}
