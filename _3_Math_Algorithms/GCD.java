package _3_Math_Algorithms;
class GCD{
	public static void main(String[] args) {
		System.out.println(GCD(100,200));
	}
	static int GCD(int a,int b){
		if(a==0)
			return b;
		return GCD(b%a,a);
	}
}