package BIT_MANIPULATION;
/**
 * FlipBit
 */
public class FlipBit {
    public static void main(String[] args) {
        System.out.println(flip(16,4));
    }
    static int flip(int n,int pos){
	    return n^(1<<pos);
	}
}