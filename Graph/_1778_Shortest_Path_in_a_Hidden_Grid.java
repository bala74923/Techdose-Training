package Graph;
import java.util.*;

public class _1778_Shortest_Path_in_a_Hidden_Grid {
    // solution

    /**
     * // This is the GridMaster's API interface.
     * // You should not implement it, or speculate about its implementation
     * class GridMaster {
     *     boolean canMove(char direction);
     *     void move(char direction);
     *     boolean isTarget();
     * }
     */
    class GridMaster { // for removing error ,just a template
          boolean canMove(char direction){ return false;}
          void move(char direction){}
          boolean isTarget(){return true;}
      }

    class Solution {

        //solution starts here
        String dirs = "ULDR";
        int[][] dirs2 = {{-1,0},{0,-1} , {1,0},{0,1}};
        int len = 1001;
        int[][] graph;
        // 0-> unvisited, 3-> blocked, 1 visited, 2 - target
        public int findShortestPath(GridMaster master) {
            // generate the matrix with start and target point
            // then do bfs
            graph = new int[len][len];
            int i = len/2 , j = len/2;
            dfs(i,j,master); // creates the graph

            Queue<int[]> q = new LinkedList<>();
            q.add( new int[]{i,j,0});
            while(!q.isEmpty()){
                int[] front = q.poll();
                int x  =front[0],y = front[1], dist = front[2];
                if(graph[x][y]==2) return dist;
                for(int[] dir: dirs2){
                    int nx = x+ dir[0], ny = y+dir[1];
                    // should not be blocked and unvisited
                    if(graph[nx][ny]==3) continue;
                    if(graph[nx][ny]==2) return dist+1;
                    q.add(new int[]{nx,ny, dist+1});
                    graph[nx][ny] = 3;
                }
            }
            return -1;
        }
        void dfs(int i,int j, GridMaster master){
            if(graph[i][j] != 0) return ; // already visited
            graph[i][j] = 1; // setting point as visited
            if(master.isTarget()) graph[i][j] = 2;
            for(int ind=0;ind<4;ind++){
                char c = dirs.charAt(ind);
                int x=  dirs2[ind][0]+i, y = dirs2[ind][1]+j;
                if(master.canMove(c)){
                    master.move(c);
                    // do dfs
                    dfs(x,y,master);
                    master.move( dirs.charAt(jumpBack(ind)) );
                }else {
                    graph[x][y] = 3;
                }
            }
        }
        int jumpBack(int ind){
            return (ind+2)%4;
        }
    }
}
