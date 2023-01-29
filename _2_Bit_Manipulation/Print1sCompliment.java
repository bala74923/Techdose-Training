package _2_Bit_Manipulation;
public class Print1sCompliment {
    public static void main(String[] args) {
        print1s(7);
    }
    static void print1s(int n){
	    System.out.println(Integer.toString(n^((1<<31)-1),2));
	}
}
