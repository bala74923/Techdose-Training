package _6_Matrix;

import java.util.ArrayList;
import java.util.List;

public class _54_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length , n = matrix[0].length , remaining = m*n;

        // {right,down,left, up}
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}} ;
        int[] dirs2 = {n,m-1};
        int index = 0,x =0,y=-1;

        while( dirs2[index&1] > 0){
            int times = dirs2[index&1];

            while(times-->0){
                x = x + dir[index%4][0];
                y = y + dir[index%4][1];
                list.add( matrix[x][y] );
            }
            dirs2[index&1]--;

            index = (++index)%4;
        }
        return list;
    }
}
