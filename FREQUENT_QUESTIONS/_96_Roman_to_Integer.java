package FREQUENT_QUESTIONS;

public class _96_Roman_to_Integer {
    public int romanToInt(String s) {
        int res = 0,prev=0;
        for(int i=0;i<s.length();i++){
            int curr = get(s.charAt(i));
            res+= curr;
            if(prev<curr) res=res - 2*prev;
            prev = curr;
        }
        return res;
    }
    int get(char c){
        switch(c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            default:
                return 1000;
        }
    }
}
