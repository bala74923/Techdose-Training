package _2_Bit_Manipulation;
/**
 * Print2sCompliment
 */
public class Print2sCompliment {
    public static void main(String[] args) {
        print2s(7);
    }
    static void print2s(int n){
	    int val = n^((1<<31)-1);
	    System.out.println(Integer.toString(val+1,2));
	}
}