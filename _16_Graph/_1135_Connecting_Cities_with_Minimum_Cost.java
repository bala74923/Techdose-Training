package _16_Graph;
import java.util.*;
public class _1135_Connecting_Cities_with_Minimum_Cost {

        //solution for leetcode judge
    class Solution {
        public int minimumCost(int n, int[][] edges) {
            // List<List<int[]>> list= toGraph(n, edges);
            //return prims(n, list);
            return kruskals(n, edges);
        }
        int kruskals(int n,int[][] edges){
            Arrays.sort(edges, (a,b)->a[2]-b[2]);
            int found = 0, sum = 0;
            int[] dsuf = new int[n+1];
            Arrays.fill(dsuf,-1);
            for(int[] e: edges){
                int u= e[0], v = e[1], dist = e[2];
                int pu = find(u, dsuf), pv = find(v, dsuf);
                if(pu!=pv){
                    dsuf[pu] = pv;
                    sum+= dist;
                    found++;
                }
            }

            return found==n-1?sum : -1;
        }
        int find(int node,int[] dsuf){
            if(dsuf[node] ==-1) return node;
            return dsuf[node] = find(dsuf[node], dsuf);
        }
        int prims(int n, List<List<int[]>> list){
            int found = 0,sum =0;
            boolean[] visited = new boolean[n+1];
            // {distance,src, parent}
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
            pq.add( new int[]{0,1,-1});

            while(!pq.isEmpty()){
                int[] front = pq.poll();
                int node = front[1],par = front[2],dist = front[0];
                if(visited[node]) continue;
                visited[node] = true;
                sum+= dist; found++;
                //System.out.println(list.get(node));
                for(int[] adj: list.get(node)){
                    // System.out.println(Arrays.toString(adj));
                    int ndist = adj[1], adj_node= adj[0];
                    pq.add(new int[]{ndist, adj_node , node});
                }
            }
            //System.out.println(found);
            return found==n?sum : -1;
        }
        List<List<int[]>> toGraph(int n,int[][] edges){
            List<List<int[]>> list = new ArrayList<>();
            for(int i=0;i<=n ;i++)
                list.add(new ArrayList<>());
            for(int[] e: edges){
                list.get(e[0]).add(new int[]{e[1],e[2]});
                list.get(e[1]).add(new int[]{e[0],e[2]});
            }
            return list;
        }
    }
}
