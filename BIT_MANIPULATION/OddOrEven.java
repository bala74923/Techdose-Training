package BIT_MANIPULATION;
public class OddOrEven {
    public static void main(String[] args) {
        System.out.println(oddOrEven(7));
    }
    static String oddOrEven(int n){
	    return (n&1)==1?"odd":"even";
	}
}
