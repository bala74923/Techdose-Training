package _6_Matrix;

public class _48_Rotate_Image {
    public void rotate(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length ;
        int a = 0, b = n-1;
        while(a<b){
            for(int i=0;i<(b-a);i++){
                int temp = matrix[a][a+i];
                matrix[a][a+i] = matrix[b-i][a];
                matrix[b-i][a] = matrix[b][b-i];
                matrix[b][b-i] = matrix[a+i][b];
                matrix[a+i][b] = temp;
            }
            a++ ; b--;
        }
    }
}
