package HASH_MAP.ASSIGNMENT;

import java.util.ArrayList;
import java.util.List;

public class _438_Find_All_Anagrams_in_a_String {


    class HashSolution {
        public List<Integer> findAnagrams(String s, String p) {
            int[] map = new int[26];
            for(char c: p.toCharArray()) map[c-'a']++;
            int[] sub= new int[26];
            int left = 0,right = 0;
            List<Integer> list = new ArrayList<>();
            while(right<s.length()){
                if(right>=p.length()) sub[s.charAt(left++)-'a']--;
                sub[s.charAt(right++)-'a']++;
                if(check(sub,map))
                    list.add(left);
            }
            return list;
        }
        static boolean check(int[] s,int[] p){
            for(int i=0;i<26;i++){
                if(s[i]!=p[i])
                    return false;
            }
            return true;
        }
    }
}
