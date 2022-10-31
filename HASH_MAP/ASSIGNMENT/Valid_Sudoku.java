package HASH_MAP.ASSIGNMENT;

public class Valid_Sudoku {
    static boolean solve(char[][] board){
        //vrow[row_no][digit_value]
        boolean[][] vrow =  new boolean[10][10],
                vcol = new boolean[10][10];
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                boolean[] vsub = new boolean[10];
                for(int i1=0;i1<3;i1++){
                    for(int j1=0;j1<3;j1++){
                        char c = board[i1+i][j1+j];
                        if(c=='.')continue;
                        int val = c-'0';
                        if(vsub[val]||vrow[i1+i][val]||vcol[j1+j][val])
                            return false;
                        vsub[val] = vrow[i1+i][val] =vcol[j1+j][val] =  true;
                    }
                }
            }
        }
        return true;
    }
    class BitManipulationSolution {
        public boolean isValidSudoku(char[][] board) {
            //vrow[row_no] (digit goes in bitwise)
            int[] vrow =  new int[10], vcol = new int[10];
            for(int i=0;i<9;i+=3){
                for(int j=0;j<9;j+=3){
                    int vsub =0 ;
                    for(int i1=0;i1<3;i1++){
                        for(int j1=0;j1<3;j1++){
                            char c = board[i1+i][j1+j];
                            if(c=='.')continue;
                            int val = c-'0';
                            if(seen(vsub,val)||seen(vrow[i1+i],val)||seen(vcol[j1+j],val))
                                return false;
                            vsub = set(vsub,val);
                            vrow[i1+i]= set(vrow[i1+i],val);
                            vcol[j1+j] = set(vcol[j1+j],val);
                        }
                    }
                }
            }
            return true;
        }
        static boolean seen(int vrow,int dig){return (vrow&(1<<dig))!=0;}
        static int set(int vrow,int dig){return (vrow|(1<<dig));}
    }
}
