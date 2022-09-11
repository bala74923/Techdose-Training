package FREQUENT_QUESTIONS;

public class P4_Number_of_Islands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1','0', '1', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'}
        };
        System.out.println(count(grid));
    }
    static int count(char[][] grid){
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    visit(i,j,grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    static void visit(int i,int j,char[][] grid){
        if(i<0||j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0')
            return ;
        grid[i][j]='0';
        visit(i-1,j,grid);
        visit(i,j+1,grid);
        visit(i+1,j,grid);
        visit(i,j-1,grid);
    }
}
