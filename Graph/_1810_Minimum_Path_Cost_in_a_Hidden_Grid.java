package Graph;
import java.util.*;
public class _1810_Minimum_Path_Cost_in_a_Hidden_Grid {

    // DFS (generate graph) + apply dijkstra onit
    class Solution {
        int len = 201,visited = -2, unvisited = -1, target = -3, blocked = -4;
        int[][] grid ;
        int ti ,tj;
        char[] dirs = "UDLR".toCharArray();
        int[][] dirs2 = {{-1,0},{1,0},{0,-1},{0,1}};
        Map< Integer, Map<Integer,List<int[]> > > map ;
        int int_max = (int)1e9;
        public int findShortestPath(GridMaster master) {
            grid = new int[len][len];
            for(int[] grid1: grid)
                Arrays.fill(grid1, unvisited); // setting all as unvisited
            int si = len/2 , sj = len/2;
            //edges = new ArrayList<>();
            map = new HashMap<>();
            //for(int )
            // create grid using dfs
            ti = tj = -1;
            dfs(si,sj,master);
            //use grid array as dp now
            for(int[] grid1: grid)
                Arrays.fill(grid1,int_max);
            grid[si][sj] = 0;
            //{i,j,cost up to now}
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
            pq.add( new int[]{si,sj,0});
            while(!pq.isEmpty()){
                int[] front = pq.poll();
                int ni = front[0],nj = front[1], dist = front[2];
                for(int[] adj: map.getOrDefault(ni,new HashMap<>()).
                        getOrDefault(nj, new ArrayList<>())){
                    int xi = adj[0],xj = adj[1], ndist = adj[2]+dist;
                    if(grid[xi][xj]> ndist){
                        grid[xi][xj] = ndist;
                        pq.add(new int[]{xi,xj, ndist});
                    }
                }
            }
            if(ti==-1||tj==-1) return -1;
            return grid[ti][tj]>=int_max?-1: grid[ti][tj];
        }
        // -2 - visited,-1 -unvisited, -3 -target , -4 - blocked
        void dfs(int i,int j,GridMaster master){
            if(grid[i][j]== visited) return ; // if already visited continue
            grid[i][j] = visited;// setting as visited
            if(master.isTarget()) {
                ti = i;tj = j;
                grid[i][j] = target ;
            }// setting it as target
            for(int ind =0;ind <4;ind++){
                char c = dirs[ind], backtrack = dirs[back(ind)];
                int x = dirs2[ind][0]+i , y = dirs2[ind][1]+j;
                if(master.canMove(c)){
                    int cost = master.move(c);
                    //edges.add(new int[]{i,j,x,y,cost});
                    addEdge(i,j,x,y,cost);
                    dfs(x,y,master);
                    master.move(backtrack);
                }else{ //blocked
                    grid[x][y] = blocked;
                }
            }
        }
        void addEdge(int i,int j,int x,int y,int cost){
            Map<Integer,List<int[]>> jind = map.getOrDefault(i, new HashMap<>());
            List<int[]> adj_list = jind.getOrDefault(j, new ArrayList<>());
            adj_list.add (new int[]{x,y,cost});
            jind.put(j, adj_list);
            map.put(i, jind);
        }
        int back(int ind){
            return ind%2==0? ++ind: --ind;
        }

    }
    class GridMaster { // for removing error ,just a template
        boolean canMove(char direction){ return false;}
        int move(char direction){ return 0;}
        boolean isTarget(){return true;}
    }
}
