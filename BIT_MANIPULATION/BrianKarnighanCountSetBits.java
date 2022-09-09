package BIT_MANIPULATION;
public class BrianKarnighanCountSetBits {
    public static void main(String[] args) {
        System.out.println(countSet((1<<31)-1));
    }   
    static int countSet(int n){
	    int count=0;
	    while(n!=0){
	        n=  n&(n-1);
	        count++;
	    }
	    return count;
	} 
}
