package Arrays.HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountAllOccurencesOfAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  s = sc.next(),  p = sc.next();
        int[] map = new int[26];
        for(char c: p.toCharArray()) map[c-'a']++;
        int K = p.length();
        int[] sub = new int[26];
        List<Integer> list = new ArrayList<>();
        //System.out.println(Arrays.toString(map));
        for(int i=0;i<s.length();i++){
            // remove outer element
            if(i-K>=0) sub[s.charAt(i-K)-'a']--;
            //add new element
            sub[s.charAt(i)-'a']++;
            // get answer
            //System.out.println(Arrays.toString(sub));
            if(equals(sub,map)) list.add(i-K+1);
        }
        System.out.println(list.size());
    }
    static boolean equals(int[] m1,int[] m2){
        for(int i=0;i<26;i++){
            if(m1[i]!=m2[i]) return false;
        }return true;
    }
}
