package FREQUENT_QUESTIONS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _97_Course_Scheduler {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //no  cycles should be formed
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] pre: prerequisites){
            int sub = pre[0],par = pre[1];
            List<Integer> parents = map.getOrDefault(sub,new ArrayList<>());
            parents.add(par);
            map.put(sub,parents);
        }
        // System.out.println(map);
        for(int val=0;val<numCourses;val++){
            if(!check(map,val,new boolean[numCourses]))
                return false;
            else map.remove(val);// if val cannot make cycle it wont form cycle starting from other cycles too
        }
        return true;
    }
    static boolean check(Map<Integer,List<Integer>> map, int val,boolean[] visited){
        if(visited[val]) return false;
        visited[val] = true;
        List<Integer> parents = map.getOrDefault(val,new ArrayList<>());
        for(int par: parents){
            if(!check(map,par,visited))
                return false;
        }
        visited[val] = false;
        return true;
    }
}
