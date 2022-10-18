package CONTEST_PROBLEMS.MEDIUM_3;

public class _B89_Maximum_sum {
    static void solve(int[] arr){
        long res = 0,sum = 0;
        for(int i=0;i<arr.length;i++){
            sum+= arr[i];
            res = Math.max(res,(sum+i)/(i+1));
        }
        System.out.println(res);
    }
}
