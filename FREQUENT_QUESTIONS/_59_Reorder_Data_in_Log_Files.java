package FREQUENT_QUESTIONS;

import java.util.Arrays;

public class _59_Reorder_Data_in_Log_Files {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(a, b)->comp(a,b));
        return logs;
    }
    int comp(String a,String b){
        boolean aa =  alpha(a),ba = alpha(b);
        if(aa!=ba) return aa?-1:1;
        if(aa){ // letter
            String[] a1 = a.split(" "), a2 = b.split(" ");
            for(int i=1;i<a1.length && i<a2.length;i++){
                if(!a1[i].equals(a2[i])){
                    return a1[i].compareTo(a2[i]);
                }
            }
            if(a1.length!=a2.length){
                return a1.length-a2.length;
            }
            return a1[0].compareTo(a2[0]);
        }
        return 0;
    }
    boolean alpha(String s){
        String[] arr = s.split(" ");
        return check(arr[1].charAt(0));
    }
    boolean check(char c){
        return 'a'<=c && c<='z';
    }
}
