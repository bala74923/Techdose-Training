package Graph;
import java.util.*;
public class _1730_Shortest_Path_to_get_food {
    //solution
    class Solution {
        int int_max = (int)1e9;
        int[][] dirs ={{-1,0},{0,-1},{1,0},{0,1}};
        public int getFood(char[][] grid) {
            int M = grid.length, N = grid[0].length;
            boolean[][] vis = new boolean[M][N];

            Queue<int[]> q = new LinkedList<>();
            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    if(grid[i][j]=='*'){
                        vis[i][j] = true;
                        q.add(new int[]{i,j,0});
                    }
                    else
                        vis[i][j] = false;
                }
            }
            while(!q.isEmpty()){
                int[] front = q.poll();
                int i = front[0],j = front[1], dist = front[2];
                if(grid[i][j]=='#')
                    return dist;
                for(int[] dir: dirs){
                    int x = dir[0]+i, y = dir[1]+j;
                    if(x>-1 && x<M && y>-1 && y<N && grid[x][y]!='X' && !vis[x][y]){
                        vis[x][y]=  true;
                        q.add( new int[]{x,y,1+dist});
                    }
                }
            }



            return -1;
        }
    }
}
