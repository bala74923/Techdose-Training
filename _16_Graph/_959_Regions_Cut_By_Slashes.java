package _16_Graph;

public class _959_Regions_Cut_By_Slashes {
    // there is also eulers formula technique check out that also
    class Solution {
        int[][] dirs ={{-1,0},{0,-1},{1,0},{0,1}};
        public int regionsBySlashes(String[] grid) {
            int m = grid.length, n = grid[0].length();
            int X = m*3, Y = n*3, jump =3 ;
            int[][] matrix= new int[X][Y];
            for(int i=0,mi =0;i<m;i++,mi+=jump){
                for(int j=0,mj =0;j<n;j++,mj+=jump){
                    if(grid[i].charAt(j)=='\\'){
                        matrix[mi][mj] = 1;
                        matrix[mi+1][mj+1] = 1;
                        matrix[mi+2][mj+2] = 1;
                    }
                    else if(grid[i].charAt(j)=='/'){
                        matrix[mi][mj+2] = 1;
                        matrix[mi+1][mj+1] = 1;
                        matrix[mi+2][mj] = 1;
                    }
                }
            }

            return count(matrix);
        }
        int count(int[][] mat){
            int m = mat.length,n = mat[0].length;
            boolean[][] vis = new boolean[m][n];
            int islands =0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j]==0 && !vis[i][j]){
                        dfs(mat,vis,i,j);
                        islands++;
                    }
                }
            }
            return islands;
        }
        void dfs(int[][] mat,boolean[][] vis,int i,int j){
            if(i<0 || j<0 || i>=mat.length || j>=mat[0].length ||
                    vis[i][j] || mat[i][j] == 1) return;
            vis[i][j] = true;
            for(int[] dir: dirs)
                dfs(mat,vis, i+dir[0],j+dir[1]);
        }
    }
}
