

	import java.util.regex.Matcher;
	
	import java.util.Scanner;

	public class Pattern {
	    public static void main(String []args)
	    {
	        Scanner in = new Scanner(System.in);
	        while(in.hasNext())
	        {
	            String IP = in.next();
	            System.out.println(IP.matches(new myRegex().pattern));
	        }

	    }

	
	
	}
	

