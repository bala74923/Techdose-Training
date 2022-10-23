package CONTEST_PROBLEMS.HARD_4;

import java.util.*;

public class _W308_Build_a_Matrix_With_Conditions {
    static int[][] solve(int k,int[][] rc,int[][] cc){
        int[][] res = new int[k][k];
        List<Integer> cols = get(cc,k);
        List<Integer> rows = get(rc,k);
        if(cols==null || rows==null) return new int[0][0];
        int[] index = new int[k+1];
        for(int i=0;i<rows.size();i++){
            index[rows.get(i)] = i; // storing the index
        }
        for(int c=0;c<k;c++){
            res[index[cols.get(c)]][c] = cols.get(c);
        }

        return res;
    }
    static List<Integer> get(int[][] conditions,int k){
        int[] map = new int[k+1];
        int[] track = new int[k+1];
        Arrays.fill(map,-1);
        for(int[] cond: conditions){
            int parent = cond[0], to = cond[1];
            int curr = 1;
            Set<Integer> visited = new HashSet<>();
            visited.add(to);
            while(track[parent]!=-1){
                if(visited.contains(parent)) return null;
                visited.add(parent);
                parent = track[parent];
                curr++;
            }
            map[to] = curr;
            track[to] = parent;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=k;i++){
            list.add(i);
        }
        Collections.sort(list,(a,b)->map[a]-map[b]);
        return list;
    }
}
