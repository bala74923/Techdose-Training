package _3_Math_Algorithms;
class printPrimeFactors{
	public static void main(String[] args) {
		printPrimeFactors(100);
	}
	static void printPrimeFactors(int n){
		int x  =n ,i=2 ;
		for(;i*i<=n;i++){
			while(x%i==0){
				System.out.print(i+" ");
				x/=i;
			}
		}
		if(x>2)
			System.out.print(x+" ");
	}
}


