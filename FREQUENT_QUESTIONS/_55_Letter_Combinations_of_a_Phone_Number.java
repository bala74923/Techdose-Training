package FREQUENT_QUESTIONS;

import java.util.ArrayList;
import java.util.List;

public class _55_Letter_Combinations_of_a_Phone_Number {
    List<String> list;
    String[] nums = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        list  = new ArrayList<>();
        if(digits.length()==0) return list;
        f(0,digits,"");
        return list;
    }
    void f(int index,String s,String curr){
        if(index==s.length()){
            list.add(curr);
            return;
        }
        for(char c:nums[s.charAt(index)-'0'].toCharArray()){
            f(index+1,s,curr+c);
        }
    }
}
