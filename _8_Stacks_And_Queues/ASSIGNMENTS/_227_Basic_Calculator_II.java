package _8_Stacks_And_Queues.ASSIGNMENTS;
import java.util.*;
public class _227_Basic_Calculator_II {
    public int calculate(String s) {
        // convert infix to postfix -> strictly monotonic increasing
        List<String> list = get(s);
        // System.out.println(list);
        List<String> output = new ArrayList<>();

        Stack<Character> stack = new Stack<>();
        for(String val: list){
            if(digit(val.charAt(0)) == 0){ // number then
                output.add(val);
            }else{
                // if curly brace just push
                char op = val.charAt(0);
                if(op=='(')
                    stack.push(op);
                else if(op==')'){ // pop out until open curly braces
                    while(stack.peek() !='(')
                        output.add(stack.pop()+"");
                    stack.pop();
                } else{
                    while(!stack.isEmpty() && get_val(stack.peek())>=get_val(op)){
                        output.add(stack.pop()+"");
                    }
                    stack.push(op);
                }

            }
        }
        while(!stack.isEmpty()){
            output.add(stack.pop()+"");
        }
        Stack<Integer> exec = new Stack<>();
        for(String val: output){
            if(digit(val.charAt(0)) == 0) exec.push(Integer.parseInt(val));
            else{
                //System.out.println(exec);
                int t2 = exec.pop(), t1 = exec.pop();
                exec.push(perform(t1,t2,val.charAt(0)));
            }
        }
        // System.out.println(output);
        // evaluate the postfix expression
        return exec.pop();
    }
    int get_val(char c){
        return c=='+'||c=='-'?1: c=='*'||c=='/'?2: c=='^'?3: 0;
    }
    int perform(int a,int b,char op){
        switch(op){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            case '^':
                return (int)Math.pow(a,b);
        }
        return -1;
    }
    List<String> get(String s){
        List<String> list = new ArrayList<>();
        int ind = 0;
        while(ind<s.length() && s.charAt(ind)==' ')
            ind++;
        boolean should_occur = true;
        while( ind<s.length() ){
            int is_alpha = digit(s.charAt(ind));

            StringBuilder sb = new StringBuilder("");
            sb.append(s.charAt(ind++));
            while(ind<s.length() && digit(s.charAt(ind)) == is_alpha && is_alpha == 0)
                sb.append(s.charAt(ind++));

            if(is_alpha == 1 && should_occur==true){
                list.add("0");
                should_occur = true;
            }if(is_alpha == 0) should_occur = false;
            if(is_alpha == 101) should_occur = true;
            list.add(sb.toString());
            //System.out.printf("until index=%d, sb=%s %d\n",ind,sb,sb.length());
            //ind++;
            while(ind<s.length() && s.charAt(ind)==' ')
                ind++;
        }
        return list;
    }
    int digit(char c){
        return ('0'<= c && c<='9')?0: c==' '?2 :c=='('?101:c==')'?102:1;
    }
}
