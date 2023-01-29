package _2_Bit_Manipulation;
/**
 * greaterPower2
 */
public class greaterPower2 {
    public static void main(String[] args) {
        System.out.println(largePower(9));
    }
    static int largePower(int n){
	    int logVal = (int)(Math.log(n)/Math.log(2));
	    return 1<<logVal;
	}
}