package STACKS_AND_QUEUES.CLASS_WORKS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class infix_to_postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(solve(input));
    }
    static int solve(String s){
        s = convertStringNormal(s);
        System.out.println(s);
        List<String> postfix = convert(s);
        return eval(postfix);
    }
    static int eval(List<String> list){
        Stack<Integer> st = new Stack<>();
        for(String s: list){
            if(isOperator(s)){
                System.out.println(s+" is operator");
                int second = st.pop(),first = st.isEmpty()?0:st.pop();
                st.push(perform(first,second,s.charAt(0)));
            }else{ //operand
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
    static int perform(int a,int b,char c){
        switch(c){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            case '^':
                return pow(a,b);//a power b
        }
        return -1;
    }
    static int pow(int a,int b){
        if(b==0) return 1;
        int val = pow(a,b/2);
        return val*val*((b&1)==1?a:1);
    }
    static boolean isOperator(String s){
        return s.length()==1 && !('0'<=s.charAt(0) && s.charAt(0)<='9');
    }
    static String convertStringNormal(String s){
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(c==' ') continue;
            else if(c=='+'||c=='-'){
                boolean present=  !st.isEmpty() &&(st.peek()==')'||('0'<=st.peek() && st.peek()<='9'));
                if(present) st.push(c);
                else{
                    st.push('0');
                    st.push(c);
                }
            }else st.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(char c: st) sb.append(c);
        return sb.toString();
    }
    static List<String> convert(String s){
        s = s.replace(" ","");
        char[] arr=  s.toCharArray();
        List<String> res = new ArrayList<>();
        Stack<Character> st = new Stack<>();
        for(int index=0;index<arr.length;index++){
            String operand = "";
            while(index<arr.length && isOperand(arr[index])) {
                operand += arr[index++];
            }
            if(operand.length()>0) res.add(operand);
            if(index == arr.length) break;
            // now it is about operators
            if(arr[index]=='(')
                st.push(arr[index]);
            else if(arr[index]==')'){
                // pop out all characters until open parantheses occurs
                while(st.peek()!='(')
                    res.add(""+st.pop());
                st.pop(); // also pop that open parantheses
            }else{
                while(!st.isEmpty() && getValue(st.peek())>=getValue(arr[index]))
                    res.add(""+st.pop());
                st.push(arr[index]);
            }
        }
        while(!st.isEmpty())
            res.add(""+st.pop());
        return res;
    }

    static boolean isOperand(char c){
        return ('0'<=c && c<='9')||Character.isAlphabetic(c);
    }
    static int getValue(char c){
        switch (c){
            case '^':
                return 3;// considering as power
            case '(':
                return 0;
            case '*':
            case '/':
                return 2;
            case '-':
            case '+':
                return 1;
        }
        return -1;
    }

}
