package _16_Graph;
import java.util.*;
public class _1820_Maximum_Number_of_Accepted_Invitations {
    // can be done using hungarian algorithm or ford fulkerson algorithm
    class Solution {
        /*
            hungarian algorithm
            =======================
            Rule 1. Only ask that girl if you haven't asked her before already.
            Rule 2. If you wish to ask a girl that's taken, she will only go with you if her current partner finds a new girl.
            so girl accept your invite on two cases:
               i) if you invited her first or
               ii) her partner can find another girl
        */
        public int maximumInvitations(int[][] grid) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int boy=0;boy<grid.length;boy++){
                dfs(boy, new HashSet<>(), grid, map);
            }
            return map.size();
        }
        boolean dfs(int boy,Set<Integer> seen,int[][] grid,Map<Integer,Integer> pair){
            for(int girl = 0;girl< grid[0].length; girl++){
                if(grid[boy][girl] ==1 && !seen.contains(girl)){
                    seen.add(girl);

                    if(!pair.containsKey(girl) || dfs(pair.get(girl), seen, grid, pair)){
                        pair.put(girl, boy);
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
