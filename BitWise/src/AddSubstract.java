
public class AddSubstract {
	 static int getSum(int a, int b) {
	        int carry=(a&b);
	        int sum=a^b;
	        if(carry==0)
	            return sum;
	        carry<<=1;
	        return getSum(carry,sum);
	    }

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		System.out.println(getSum(a,b));
		
		System.out.println(getSum(-a,b));

	}

}
