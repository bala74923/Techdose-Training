package FREQUENT_QUESTIONS;

import java.util.HashMap;
import java.util.Map;

public class _60_Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer> map = new HashMap<>();
        // map.put(0,1);
        int res = 0;
        for(int n: time){
            int curr = n%60, need = (60 - curr)%60;
            res+= map.getOrDefault(need,0);
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        return res;
    }
}
