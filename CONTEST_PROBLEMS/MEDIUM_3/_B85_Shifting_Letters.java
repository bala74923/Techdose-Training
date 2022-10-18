package CONTEST_PROBLEMS.MEDIUM_3;
import java.util.Arrays;
import java.util.Scanner;

public class _B85_Shifting_Letters {
    int inf= Integer.MAX_VALUE, ninf = Integer.MIN_VALUE;
    int mod = (int)1e9+7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
    /*
        difference array concept
         used for more no of updation and minimum number of retrieval

         -1 mod 26= 25 mod 26
         can be done by add (num+26)%26
     */
    static String solve(String s,int[][] queries){
        int N = s.length();
        int[] difference = new int[N];
        char[] arr = s.toCharArray();
        for(int[] q: queries){
            int start = q[0], end =q[1], direction = q[2];
            if(direction==1) {
                difference[start]++;
                if(end+1<N) difference[end+1]--;
            }else{
                difference[start]--;
                if(end+1<N) difference[end+1]++;
            }
        }
        System.out.println(Arrays.toString(difference));
        int currDiff = 0;
        for(int i=0;i<N;i++){
            currDiff+= difference[i];
            int add = (currDiff+26)%26;// -1 mod 26 => 25 mod 26
            int sum = (arr[i]-'a'+ add)%26;
            //System.out.printf(" add=%d sum=%d \n",add,sum);
            arr[i] = (char)('a'+sum);
        }
        return new String(arr);
    }
}
