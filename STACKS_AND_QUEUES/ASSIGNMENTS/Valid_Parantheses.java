package STACKS_AND_QUEUES.ASSIGNMENTS;

public class Valid_Parantheses {
    public boolean isValid(String s) {
        char[] st = new char[s.length()];
        int top=-1;
        for(char c: s.toCharArray()){
            if("({[".indexOf(c)!=-1){
                st[++top] = c;
            }else{
                // element at top should match
                if(top==-1) return false;
                if("([{".indexOf(st[top])!=")]}".indexOf(c))
                    return false;
                top--;// else pop the element
            }
        }
        return top==-1;// at last stack should be empty
    }
}
