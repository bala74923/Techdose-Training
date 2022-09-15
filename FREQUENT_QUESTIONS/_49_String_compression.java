package FREQUENT_QUESTIONS;

public class _49_String_compression {
    public int compress(char[] chars) {
        int ans = 0;
        for(int i=0;i<chars.length;){
            char c = chars[i];
            int j=i;
            while(j<chars.length && chars[j]==c){
                j++;
            }
            int count = j-i;
            chars[ans++]=c;
            if(count!=1){
                for(char ch:(count+"").toCharArray()){
                    chars[ans++] = ch;
                }
            }
            i=j;
        }
        return ans;
    }
}
