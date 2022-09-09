package MATH_ALGORITHMS;
import java.util.*;
class FindAllFactors{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//int n = sc.nextInt();
		System.out.println(catalan.catalanNos(4));
	}
	static void printFactors(int n){
		int i=1;
		while(i*i<n){
			if(n%i==0){
				System.out.print(i+","+(n/i)+",");
			}
			i++;
		}
		if(i*i==n)
			System.out.print(i);
	}
	
	
	
	
	
	
}