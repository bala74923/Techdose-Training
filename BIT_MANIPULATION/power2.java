package BIT_MANIPULATION;
public class power2 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(8));
    }
    static boolean isPowerOf2(int n){
        return (n&(n-1)) ==0;
    }
}
