package FREQUENT_QUESTIONS;

public class _76_Word_Search {
    public boolean exist(char[][] board, String word) {
        int r = board.length,c = board[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(check(i,j,board,word,0,new boolean[r][c]))
                    return true;
            }
        }
        return false;
    }
    static boolean check(int i,int j,char[][] board,String word,int index,boolean[][] visited){
        if(index==word.length()) {
            return true;
        }
        // non working condition
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j] ||
                board[i][j] != word.charAt(index))
            return false;
        visited[i][j] = true;
        boolean res = false;
        res = res || check(i-1,j,board,word,index+1,visited);
        res =  res|| check(i+1,j,board,word,index+1,visited);
        res = res|| check(i,j-1,board,word,index+1,visited);
        res = res|| check(i,j+1,board,word,index+1,visited);
        visited[i][j] = false;
        return res;
    }
}
