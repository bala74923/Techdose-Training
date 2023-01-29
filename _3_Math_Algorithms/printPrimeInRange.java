package _3_Math_Algorithms;
class printPrimeInRange{
	public static void main(String[] args) {
		printPrimeinRange(100);
	}
	static void printPrimeinRange(int n){
		boolean[] isPrime = new boolean[n+1];
		for(int i=2;i<=n;i++){
			isPrime[i] = true;
		}
		for(int i=2;i*i<=n;i++){
			if(isPrime[i]){
				for(int j=2;j*i<=n;j++){
					isPrime[i*j]= false;
				}
			}
		}
		System.out.println("Prime numbers in range are:");
		for(int i=1;i<=n;i++){
			if(isPrime[i]){
				System.out.print(i+",");
			}
		}

	}
}