package HASH_MAP.ASSIGNMENT;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49_Group_Anagrams {
    int mod  = (int)1e9+7;
    int[] alpha = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,101};
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long,List<String>> map = new HashMap<>();
        for(String s: strs){
            long val = strToInt(s);
            List<String> l1 = map.getOrDefault(val,new ArrayList<>());
            l1.add(s);
            map.put(val,l1);
        }
        List<List<String>> list = new ArrayList<>(map.values());
        return list;
    }
    long  strToInt(String s){
        long res = 1;
        for(char c: s.toCharArray()){
            res = ((res%mod)*alpha[c-'a'])%mod;
        }
        return res;
    }
}
