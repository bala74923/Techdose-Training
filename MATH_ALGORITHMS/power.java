package MATH_ALGORITHMS;
class power{
	public static void main(String[] args) {
		System.out.println(pow(2,45));
	}
	static long pow(int val,int n){
		if(n==1)
			return val;
		long calc = pow(val,n/2);
		System.out.println(val+","+(n>>1)+"="+calc);
		return calc*calc*((n&1)==1?val:1);
	}
}