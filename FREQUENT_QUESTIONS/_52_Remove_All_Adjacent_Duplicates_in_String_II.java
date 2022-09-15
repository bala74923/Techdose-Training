package FREQUENT_QUESTIONS;

import java.util.Stack;

public class _52_Remove_All_Adjacent_Duplicates_in_String_II {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            //check is st's previous is same
            if(!st.isEmpty() && st.peek()[0]==s.charAt(i)-'a'){
                int count =st.peek()[1],j=i;
                while(j<s.length()&& count<k && s.charAt(i)==s.charAt(j)){
                    count++;
                    j++;
                }
                if(count==k){
                    //removal should be done
                    st.pop();
                }else{
                    //should be upadated
                    st.pop();
                    st.push(new int[]{s.charAt(i)-'a',count});
                }
                i=j-1;
            }else{
                st.push(new int[]{s.charAt(i)-'a',1});
            }
        }


        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()){
            sb.append(get(st.pop()));
        }
        return sb.reverse().toString();
    }
    String get(int[] arr){
        return (((char)(arr[0]+'a'))+"").repeat(arr[1]);
    }

}
