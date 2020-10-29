//https://leetcode.com/problems/string-to-integer-atoi/
//Finite State Machine
public class Atoi08 {
	 public static int myAtoi(String str) 
	 {
		 int result=0;
		 int sign=0;
		 for(int i=0;i<str.length();i++) {
			 char c=str.charAt(i);
			 if(Character.isDigit(c)) {
				 sign=1;
				 result=result*10 + c-'0';
				 
			 }
			 else if(sign==0) {
				 if(c==' ')continue;
				 if(c=='+') {
					 sign=1;
				 }
				 if(c=='-') {
					 sign=-1;
				 }
				 else
					 return 0;
			 }
			 else {
				 return (int)(sign * result);
			 }
			 if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
	            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
	        }
	        return (int) (sign * result);
		
	 }

	public static void main(String[] args) {
		String str="42";
		System.out.println(myAtoi(str));

	}

}
