package _2_Bit_Manipulation;
public class SetBit {
    public static void main(String[] args) {
        System.out.println(setBit(6,0));
    }
    static int setBit(int n,int pos){
	    return n|(1<<pos);
	}
}
