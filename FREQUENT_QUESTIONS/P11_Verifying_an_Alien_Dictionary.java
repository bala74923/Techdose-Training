package FREQUENT_QUESTIONS;

public class P11_Verifying_an_Alien_Dictionary {
    public static void main(String[] args) {

    }
    static int[] alpha;
    static boolean isAlienSorted(String[] words, String s) {
        alpha = new int[26];
        for(int i=0;i<s.length();i++){
            alpha[s.charAt(i)-'a'] = i;
        }
        for(int i=1;i<words.length;i++){
            if(!comp(words[i-1],words[i],alpha))
                return false;
        }
        return true;
    }
    static boolean comp(String a,String b,int[] alpha){
        int i=0,j=0;
        while(i<a.length() && j<b.length()){
            int ind1 = alpha[a.charAt(i)-'a'];
            int ind2=  alpha[b.charAt(j)-'a'];
            if(ind1!=ind2)
                return ind1<ind2;
            i++;j++;
        }
        return i==a.length();
    }

}
