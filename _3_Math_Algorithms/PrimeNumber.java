package _3_Math_Algorithms;
import java.util.Scanner;
class PrimeNumber{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(isPrime(n)?"prime Number":"Not Prime Number");
	}
	static boolean isPrime(int n){
		if(n==1)
			return false;
		for(int i=2;i*i<=n;i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
}