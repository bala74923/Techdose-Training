package FREQUENT_QUESTIONS;

import java.util.Stack;

public class _78_Decode_String {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> str = new Stack<>();
        Stack<Integer> it = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                str.push("[");
            }
            else if(Character.isAlphabetic(s.charAt(i))){
                str.push(s.charAt(i)+"");
            }
            else if(s.charAt(i)==']'){
                String sub = "";
                while(!str.peek().equals("[")){
                    sub = str.pop()+sub;
                }
                int currTime = it.pop();
                str.pop();
                str.push(sub.repeat(currTime));
                //System.out.println(sub+"=>"+currTime);
            }else{
                int j = i, times =0;
                while(j<s.length() && '0'<=s.charAt(j) && s.charAt(j)<='9'){
                    times = times*10 + (s.charAt(j++)-'0');
                }
                it.push(times);
                i=j-1;
            }
        }
        //System.out.println(str);
        for( String curr: str)
            sb.append(curr);
        return sb.toString();
    }
}
