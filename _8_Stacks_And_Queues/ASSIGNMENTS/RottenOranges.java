package _8_Stacks_And_Queues.ASSIGNMENTS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static int solve(int[][] arr){
        int m = arr.length, n= arr[0].length;
        Queue<int[]> q = new LinkedList<>();
        // directions
        int[][] dirs ={{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][] visited = new boolean[m][n];
        int remaining = 0;
        // add all rotten oranges first
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==2) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
                if(arr[i][j]==1) remaining++;
            }
        }
        // made a visited array
        int minutes= 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] front = q.poll();
                for (int[] dir : dirs) {
                    int x = front[0] + dir[0], y = front[1] + dir[1];
                    // valid , not visited , fresh oranges
                    if (x > -1 && y > -1 && x < m && y < n && !visited[x][y] && arr[x][y] == 1) {
                        arr[x][y] = 2;
                        visited[x][y] = true;
                        q.add(new int[]{x, y});
                        remaining--;
                    }
                }
            }
            if(remaining==0) return minutes;
            ++minutes;
        }

        return remaining>0?-1:minutes;
    }
}
