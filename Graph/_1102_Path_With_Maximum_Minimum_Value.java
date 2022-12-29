package Graph;
import java.util.*;
public class _1102_Path_With_Maximum_Minimum_Value {
    //solution
    class Solution {
        int[][] dirs = { {-1,0} , {0,-1} , {0,1} , {1,0} };
        public int maximumMinimumPath(int[][] grid) {
            // score of path is minimum value in thatpath
            // pick max out of all paths
            // priority queue should be picking max score

            //{i,j,min until now}

            int M = grid.length, N = grid[0].length;
            int[][] dp = new int[M][N];
            for(int[] dp1: dp)
                Arrays.fill(dp1, -1);
            dp[0][0] = 0;

            PriorityQueue<int[]> pq =
                    new PriorityQueue<>((a,b)->b[2]-a[2]);
            pq.add( new int[]{0,0,grid[0][0]});

            while(!pq.isEmpty()){
                int[] front = pq.poll();
                int i = front[0], j =front[1], mini = front[2];
                for(int[] dir: dirs){
                    int x= dir[0]+i, y = dir[1]+j;
                    if(x>-1 && y>-1 && x<M && y<N){
                        int new_mini = Math.min(mini, grid[x][y]);
                        if(new_mini>dp[x][y]){
                            dp[x][y] = new_mini;
                            pq.add(new int[]{x,y,new_mini});
                        }
                    }
                }
            }

            return dp[M-1][N-1];
        }
    }

}
