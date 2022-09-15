package FREQUENT_QUESTIONS;

import java.util.HashMap;
import java.util.Map;

public class _27_UndergroundSystem {
    Map<Integer,Integer> idTime; // id, in time
    Map<Integer,String> idStation;
    Map<String,Integer> time,len;// (from-to, timetaken) (from-to,occurence)
    public _27_UndergroundSystem() { // constructor
        idTime =new HashMap<>();
        idStation =new HashMap<>();
        time = new HashMap<>();
        len = new HashMap<>();
    }

    public void checkIn(int id, String name, int t) {
        idStation.put(id,name);
        idTime.put(id,t);
    }

    public void checkOut(int id, String name, int t) {
        String from = idStation.get(id),to= name,path = from+"-"+to;
        int start = idTime.get(id);
        time.put(path,time.getOrDefault(path,0)+t-start);
        len.put(path,len.getOrDefault(path,0)+1);
    }

    public double getAverageTime(String from, String to) {
        String path = from+"-"+to;
        double dist = time.get(path);
        return dist/len.get(path);
    }
}
