package FREQUENT_QUESTIONS;

public class _67_Rotate_Image {
    public void rotate(int[][] arr) {
        int a = 0, b = arr.length-1;
        while(a<b){
            for(int i=0;i<(b-a);i++){
                int temp = arr[b-i][a];
                arr[b-i][a] = arr[b][b-i];
                arr[b][b-i] = arr[a+i][b];
                arr[a+i][b] = arr[a][a+i];
                arr[a][a+i] = temp ;

            }
            a++;b--;
        }
    }
}
/*
          col = a                    col = b
          +         (a,a+i)          +
          +--------------------------+---------------row = a
(b-i,a)   +                          +(a+i,b)
          +                          +
          +--------------------------+---------------row= b
                    (b,b-i)
*/
