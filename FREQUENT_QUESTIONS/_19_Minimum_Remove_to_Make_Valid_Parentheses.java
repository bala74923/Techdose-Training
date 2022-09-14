package FREQUENT_QUESTIONS;

import java.util.Stack;

public class _19_Minimum_Remove_to_Make_Valid_Parentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        int opened = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                st.push(i);
            }else if(c==')'){
                if(st.isEmpty()||s.charAt(st.peek())==')') st.push(i);
                else st.pop();
            }
        }
        System.out.println(st);
        StringBuilder sb = new StringBuilder("");
        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(!st.isEmpty() && st.peek()==i){
                st.pop();
            }else sb.append(c);
        }
        return sb.reverse().toString();
    }
}
