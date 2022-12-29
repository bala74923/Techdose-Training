package Graph;
import java.util.*;
public class _261_Graph_Valid_Tree {
    // solution here
    class Solution {
        public boolean validTree(int n, int[][] edges) {
            boolean[] visited = new boolean[n];
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<n;i++)
                list.add( new ArrayList<>());
            for(int[] e: edges){
                int from = e[0], to = e[1];
                list.get(from).add(to);
                list.get(to).add(from);
            }
            if(cycle(0,-1,visited,list)){
                return false;// cycle occurs so no tree
            }else{
                // if it is disconnected then also not tree
                for(int i=0;i<n;i++){
                    if(!visited[i])
                        return false;
                }
            }
            return true;// no cycle so tree
        }
        boolean cycle(int curr,int parent,boolean[] visited, List<List<Integer>> list){
            if(visited[curr]) return true;
            visited[curr] = true;
            for(int adj: list.get(curr)){
                if(adj!=parent && cycle(adj,curr,visited, list)){
                    return true;
                }
            }
            return false;
        }

    }
}
