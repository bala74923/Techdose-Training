package Graph;
import java.util.*;
public class _1584_Min_Cost_to_Connect_All_Points {
    // leetcode solution here
    class Solution {
        int distance(int i,int j,int[][] points){
            return Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
        }
        public int minCostConnectPoints(int[][] points) {
            return kruskals(points);
        }
        int prims(int[][] points){
            int N = points.length;
            int mst_sum = 0;
            boolean[] visited = new boolean[N];

            //as we are only calculating mst sum
            //{cost , node, parent} here parent not needed
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
            pq.add( new int[]{0,0});
            while(!pq.isEmpty()){
                int[] front = pq.poll();
                int node = front[1], cost = front[0];
                if(visited[node]) continue;
                visited[node] = true;
                mst_sum+= cost;
                for(int i=0;i<N;i++){ // all nodes are adj
                    int cdist = distance(node ,i ,points);
                    int adj_node= i;
                    pq.add( new int[]{cdist,adj_node} );
                }
            }


            return mst_sum;
        }
        int kruskals(int[][] points){
            // {i,j,cost};
            int N = points.length;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
            for(int i=0;i< N;i++){
                for(int j=i+1;j<N;j++){
                    pq.add(new int[]{i,j,distance(i,j,points)});
                }
            }
            int total_cost = 0,picked = 0;
            int[] dsuf = new int[N];
            Arrays.fill(dsuf , -1);
            while(!pq.isEmpty() && picked<N-1){
                int[] front = pq.poll();
                int from = front[0], to = front[1], cost = front[2];
                if(union(from,to,dsuf)){
                    total_cost+= cost;
                    picked++;
                }
            }
            return total_cost;
        }
        boolean union(int u,int v,int[] dsuf){
            int pu = find(u,dsuf),pv = find(v,dsuf);
            if(pu==pv) return false;
            else {
                dsuf[pu] = pv; // united two sets
                return true;
            }
        }
        int find(int u,int[] dsuf){
            if(dsuf[u]==-1)
                return u;
            return dsuf[u] = find(dsuf[u], dsuf);
        }
    }
}
