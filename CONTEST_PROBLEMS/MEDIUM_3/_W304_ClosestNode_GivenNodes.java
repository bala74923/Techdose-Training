package CONTEST_PROBLEMS.MEDIUM_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _W304_ClosestNode_GivenNodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer,Integer> map1 = travel(edges,node1), map2 = travel(edges,node2);
        int dist = Integer.MAX_VALUE, res = -1;
        for(int n: map1.keySet()){
            if(map2.containsKey(n)){
                int currDist = Math.max(map1.get(n), map2.get(n));
                if(currDist<dist){
                    dist =  currDist;
                    res = n;
                }if(currDist==dist) res = Math.min(res,n);

            }
        }
        // System.out.println("map1 = "+map1);
        // System.out.println("map1 = "+map2);
        return res;
    }
    Map<Integer,Integer> travel(int[] edges,int node){
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int level =0;
        while(node!=-1){
            if(visited.contains(node)) break;
            map.put(node,level++);
            visited.add(node);
            int child = edges[node];
            node = child;
        }
        return map;
    }
}
