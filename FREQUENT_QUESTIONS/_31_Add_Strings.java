package FREQUENT_QUESTIONS;

public class _31_Add_Strings {
    public String addStrings(String num1, String num2) {
        String ans = "";
        int i = num1.length()-1,j = num2.length()-1,carry = 0;
        while(i>=0||j>=0){
            int a = i>-1?num1.charAt(i--)-'0':0;
            int b = j>-1?num2.charAt(j--)-'0':0;
            int sum = a+b+carry;
            carry  =sum/10;
            sum%=10;
            ans = sum + ans;
        }
        if(carry!=0) ans = carry+ ans;
        return ans;
    }
}
