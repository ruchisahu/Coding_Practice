import java.util.Scanner;

public class Split 
{
	 public static void main(String[] args) 
	    {
	        Scanner scan = new Scanner(System.in);
	        String A = scan.nextLine();
	        // Write your code here.
	         A=A.trim();
	        if (A.isEmpty()) {
	            System.out.println(0);
	        }
	        else 
	        {
	            String []a = A.split("'+( +|)| +|!+( +|)|,+( +|)|_+( +|)|@+( +|)|\\.+( +|)|\\?+( +|)|\\\\+( +|)");
	            System.out.println(a.length);
	                for (int i = 0; i < a.length; i++) 
	                {                
	                                System.out.println(a[i]);
	                }
	        }
	        scan.close();
	    }
}
