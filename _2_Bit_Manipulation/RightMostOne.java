package _2_Bit_Manipulation;
public class RightMostOne {
    public static void main(String[] args) {
        System.out.println(rightMostOne(10));
    }
    static int rightMostOne(int n){
	    int index=0;
	    while((n&1)!=1){
	        n>>=1;
	        index++;
	    }
	    return index;
	}
}
