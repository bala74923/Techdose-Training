package _5_Arrays.HomeWork;

public class _370_Range_Addition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] inc = new int[length];
        for(int[] up: updates){
            int L = up[0], R = up[1], num = up[2];
            inc[L]+= num ;
            if(R<length-1)
                inc[R+1]-=num;
        }
        for(int i=1;i<length;i++)
            inc[i]+= inc[i-1];
        return inc ;
    }
}
