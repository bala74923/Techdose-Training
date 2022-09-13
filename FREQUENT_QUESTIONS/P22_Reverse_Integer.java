package FREQUENT_QUESTIONS;

public class P22_Reverse_Integer {
    int max = (int)(1<<31)-1;
    public int reverse(int x) {
        int val = 0,sign = x<0?-1:1;
        x = Math.abs(x);
        while(x!=0){
            // checking appending an integer makes over flow or no
            if((max-x%10)/10<val) return 0;

            val = val*10+ (x%10);
            x/=10;
        }
        return sign*val;
    }
}
