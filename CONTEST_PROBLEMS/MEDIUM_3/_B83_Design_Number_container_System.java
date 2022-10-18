package CONTEST_PROBLEMS.MEDIUM_3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class _B83_Design_Number_container_System {
    Map<Integer, TreeSet<Integer>> map;
    Map<Integer,Integer> arr;
    public void NumberContainers() {
        map = new HashMap<>();
        arr = new HashMap<>();
    }

    public void change(int index, int number) {
        int prev = arr.getOrDefault(index,-1);
        if(prev==number) return ;
        arr.put(index,number);
        TreeSet<Integer> inds = map.getOrDefault(number, new TreeSet<>());
        inds.add(index);
        map.put(number,inds);
        if(prev!=-1){
            TreeSet<Integer> set = map.get(prev);
            set.remove(index);
            if(set.size()==0) map.remove(prev);
        }
    }

    public int find(int number) {
        if(map.get(number)==null) return -1;
        return map.get(number).first();
    }
}
