package BIT_MANIPULATION;
/**
 * UnsetBits
 */
public class UnsetBits {
    public static void main(String[] args) {
        System.out.println(unset(2, 1));
    }
    static int unset(int n,int pos){
	    return n&(~(1<<pos));
	}
}
