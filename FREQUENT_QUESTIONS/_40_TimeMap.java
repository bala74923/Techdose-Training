package FREQUENT_QUESTIONS;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _40_TimeMap {
    Map<String, TreeMap<Integer,String>> map;
    public _40_TimeMap() {
        map= new HashMap<>();
    }

    public void set(String key, String value, int time) {
        TreeMap<Integer,String> inMap = map.getOrDefault(key,new TreeMap<>());
        inMap.put(time,value);
        map.put(key,inMap);
    }

    public String get(String key, int timestamp) {
        if(map.get(key)==null) return "";
        TreeMap<Integer,String> inMap = map.get(key);
        try{
            int timeGot = inMap.floorKey(timestamp);
            return inMap.get(timeGot);
        }catch(Exception e){
            return "";
        }
    }
}
