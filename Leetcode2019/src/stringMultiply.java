
public class stringMultiply
{
    public static String multiply(String num1, String num2) 
    {
       int n1=Integer.valueOf(num1);
       int n2=Integer.valueOf(num2);
     //  System.out.println(n1*n2);
       int k=0;
       int val=0;
    	    int m = num1.length(), n = num2.length();
    	    int[] pos = new int[m + n];
    	   
    	    for(int i = m - 1; i >= 0; i--)
    	    {
    	    	int carry=0;
    	    	
    	    	
    	    String str="";
    	        for(int j = n - 1; j >= 0; j--) 
    	        {
    	        	
    	            int mul = (carry + (num1.charAt(i) - '0') * (num2.charAt(j) - '0')); 
    	           
    	            System.out.println("val="+mul);
    	            carry=mul / 10;
    	            mul=mul%10;
    	            str=mul+str;
    	            System.out.println("str"+str);
    	        }
    	        str=carry+str;
    	         val+=Integer.valueOf(str);
    	         System.out.println("str="+val);
    	         val=val * 10^k;
    	         k=k+1;
    	        System.out.println("str="+val);
    	        System.out.println(".................");
    	    }
    	            
       
       return "0"; 
    }

	public static void main(String[] args)
	{
		String num1="123";
		String num2="456";
		System.out.println(multiply(num1,num2)) ;
	}

}
