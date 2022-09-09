package BIT_MANIPULATION;
/**
 * countSetBits
 */
public class countSetBits {
    public static void main(String[] args) {
        System.out.println(count(10));
    }
    static int count(int n){
        int val = 0;
        while(n!=0){
            val+= (n&1);
            n>>=1;
        }
        return val;
    }
}