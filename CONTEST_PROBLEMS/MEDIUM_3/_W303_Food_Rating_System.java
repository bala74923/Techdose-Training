package CONTEST_PROBLEMS.MEDIUM_3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class _W303_Food_Rating_System {
    Map<String, TreeSet<String>> map;
    Map<String,Integer> rate;
    Map<String,String> spice;
    public void FoodRatings(String[] f, String[] c, int[] r) {
        map = new HashMap<>();
        rate = new HashMap<>();
        spice = new HashMap<>();
        //for(int i=0;i<f.length;i++) rate.put(f[i],r[i]);
        for(int i=0;i<f.length;i++){
            rate.put(f[i],r[i]);
            spice.put(f[i],c[i]);

            map.putIfAbsent(c[i], new TreeSet<>((a,b)->{
                if(rate.get(a).intValue()!=rate.get(b).intValue()) return rate.get(b)-rate.get(a);
                return a.compareTo(b);
            }));
            map.get(c[i]).add(f[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        TreeSet<String> pq = map.get(spice.get(food));
        pq.remove(food);
        rate.put(food, newRating);
        pq.add(food);
    }

    public String highestRated(String cuisine) {

        return map.get(cuisine).first();
    }
}
