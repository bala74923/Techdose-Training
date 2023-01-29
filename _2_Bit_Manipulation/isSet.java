package _2_Bit_Manipulation;
public class isSet {
    public static void main(String[] args) {
        System.out.println(isSetPos(2,1));
        System.out.println(isSetPos(5,2));
    }
    static boolean isSetPos(int n,int pos){
        return (n&(1<<pos))!=0;
    }
}