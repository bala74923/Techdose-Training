package CONTEST_PROBLEMS.MEDIUM_3;
import java.util.Arrays;
public class _B77_Count_Unguarded_Cells_in_the_Grid {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(mat[i],1);
        //-1 walls ,-5-> guard,0 -> guarded,1->unguarded
        for(int[] i: walls) mat[i[0]][i[1]] = -1;
        for(int[] i: guards) mat[i[0]][i[1]] = -5;
        for(int i=0;i<m;i++){
            int left = 0,right = n-1;
            int lug = 1,rug = 1;
            for(;left<n;left++,right--){
                if(mat[i][left]==-5)lug=0;
                else if(mat[i][left]==-1) lug=1;
                else mat[i][left]&=lug;

                if(mat[i][right]==-5)rug=0;
                else if(mat[i][right]==-1) rug=1;
                else mat[i][right]&=rug;
            }
        }
        for(int i=0;i<n;i++){
            int left = 0,right = m-1;
            int lug = 1,rug = 1;
            for(;left<m;left++,right--){
                if(mat[left][i]==-5)lug=0;
                else if(mat[left][i]==-1) lug=1;
                else mat[left][i]&=lug;

                if(mat[right][i]==-5)rug=0;
                else if(mat[right][i]==-1) rug=1;
                else mat[right][i]&=rug;
            }
        }
        int res =0 ;
        for(int[] m1: mat){
            for(int m11: m1) res+=(m11==1?1:0);
        }
        // print(mat);
        return res;
    }
    static void print(int[][] mat){
        System.out.println(Arrays.deepToString(mat));
    }
}
