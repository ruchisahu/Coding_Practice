
public class Power {
	 public static double myPow(double x, int n) {
		 if(n==0)return 1;
		 if(n<0) {
			 return 1/x*myPow(1/x,-(n+1));
		 }
		 
		 return (n%2==0)?myPow(x*x,n/2):x*myPow(x*x,n/2);
	 }

	public static void main(String[] args) {
		double x=2;
		int n=10;
		System.out.print(myPow(x,n));

	}

}
