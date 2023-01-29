package _9_Hash_Map.ASSIGNMENT;

import java.util.*;

class RandomizedSet {
    Map<Integer,Integer> map;
    List<Integer> list ;
    public RandomizedSet() {
        map = new HashMap<>();
        list=  new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            int ind = map.get(val),n = list.size();
            list.set(ind,list.get(n-1));
            list.set(n-1,val);
            list.remove(n-1);//remove last

            map.remove(val);
            if(ind<list.size())
                map.put(list.get(ind),ind); // swapped val
            return true;
        }return false;
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
