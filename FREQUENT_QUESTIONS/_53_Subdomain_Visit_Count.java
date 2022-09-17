package FREQUENT_QUESTIONS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _53_Subdomain_Visit_Count {
    public List<String> subdomainVisits(String[] cpdomains) {
        map = new HashMap<>();
        for(String s:cpdomains){
            get(s);
        }
        //System.out.println(map);
        List<String> list = new ArrayList<>();
        for(String key:map.keySet()){
            list.add(map.get(key)+" "+key);
        }
        return list;
    }
    Map<String,Integer> map;
    void get(String s){
        String[] str = s.split(" ");
        int val = Integer.parseInt(str[0]);
        String[] name = str[1].split("[.]");
        String curr = "";
        for(int i = name.length-1;i>=0;i--){
            curr= name[i]+(curr.length()>0?".":"")+curr;
            map.put(curr,map.getOrDefault(curr,0)+val);
        }
    }
}
