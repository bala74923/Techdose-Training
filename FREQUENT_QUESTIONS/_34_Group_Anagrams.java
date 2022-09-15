package FREQUENT_QUESTIONS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _34_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String s:strs){
            String key = getList(s);
            List<String> sub = map.getOrDefault(key,new ArrayList<>());
            sub.add(s);
            map.put(key,sub);
        }

        List<List<String>> list = new ArrayList<>();
        for(String key: map.keySet()){
            list.add(map.get(key));
        }
        return list;
    }
    String getList(String str){
        int[] hash = new int[26];
        for(char c:str.toCharArray()){
            hash[c-'a']++;
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<26;i++){
            sb.append(hash[i]);
            sb.append(",");
        }
        return sb.toString();
    }
}
