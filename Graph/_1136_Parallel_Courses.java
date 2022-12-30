package Graph;
import java.util.*;
public class _1136_Parallel_Courses {

    //leetcode solution here
    class Solution {
        public int minimumSemesters(int n, int[][] relations) {
            // do topological sort like bfs with levels and return levels
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<=n;i++) list.add(new ArrayList<>());
            int[] in = new int[n+1];
            for(int[] e: relations){
                list.get(e[0]).add(e[1]);
                //e[0]->e[1]
                in[e[1]]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for(int i=1;i<=n;i++){
                if(in[i]==0) q.add(i);
            }
            int level = 0;
            while(!q.isEmpty()){
                for(int i =q.size();i>0;i--){
                    int front= q.poll();
                    for(int adj: list.get(front)){
                        in[adj]--;
                        if(in[adj]==0)
                            q.add(adj);
                    }
                }
                level++;
            }
            // if any course cannot be taken then -1
            for(int i=1;i<=n;i++){
                if(in[i]!=0) return -1;
            }
            return level;
        }
    }
}
