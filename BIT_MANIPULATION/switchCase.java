package BIT_MANIPULATION;
/**
 * switchCase
 */
public class switchCase {
    public static void main(String[] args) {
        System.out.println(switchCase('z'));
        System.out.println(switchCase('Z'));
    }
    static char switchCase(char c){
	    return (char)(c^32);
	}
}