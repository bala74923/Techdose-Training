package CONTEST_PROBLEMS.MEDIUM_3;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class w_314_lexicographic_small_str {
    int inf= Integer.MAX_VALUE, ninf = Integer.MIN_VALUE;
    int mod = (int)1e9+7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(solve(input));
    }
    static String solve(String s){
        StringBuilder sb = new StringBuilder("");
        Stack<Character> st = new Stack<>();
        int[] count= new int[26];
        for(char c: s.toCharArray()) count[c-'a']++;
        for(char c: s.toCharArray()){
            count[c-'a']--;
            st.push(c);
            while(!st.isEmpty() && !hasLower(count,st.peek())){
                sb.append(st.pop());
            }
           // System.out.println(st);
        }
        return sb.toString();
    }
    static boolean hasLower(int[] count,char c){
        for(int i=0;i<c-'a';i++){
            if(count[i]!=0) return true;
        }
        return false;
    }
}
