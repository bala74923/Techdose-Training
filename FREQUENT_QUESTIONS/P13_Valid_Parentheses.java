package FREQUENT_QUESTIONS;

public class P13_Valid_Parentheses {
    public static void main(String[] args) {
        System.out.println(isValid("([])"));
    }
    static boolean isValid(String s) {
        int len = s.length();
        char[] st = new char[len+1];
        int top=-1;
        for(char c:s.toCharArray()){
            if(c=='{'||c=='['||c=='('){
                st[++top] = c;
            }else{
                if(top==-1) return false;
                int prev = st[top--];
                if((prev=='{' && c=='}')||(prev=='(' && c==')')
                        ||(prev=='[' && c==']'))
                    continue;
                return false;
            }
        }
        return top==-1;
    }
}
