package FREQUENT_QUESTIONS;

import java.util.HashSet;
import java.util.Set;

public class P2_Robot_Bounded_In_Circle{
    public static void main(String[] args) {

    }
    static boolean isCircle(String s){
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int x=0,y=0,index=0;
        for(char c:s.toCharArray()){
            if(c=='G'){
                x+=dirs[index][0];
                y+=dirs[index][1];
            }else if(c=='L'){
                index = index==0?3:index-1;
            }else if(c=='R'){
                index = (++index)%4;
            }
        }
        if(x==0&&y==0) return true;
        return index!=0;
    }
}
