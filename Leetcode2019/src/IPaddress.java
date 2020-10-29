import java.util.ArrayList;
import java.util.List;

public class IPaddress {
	 public static List<String> restoreIpAddresses(String s)
	    {
		 List<String> result=new ArrayList<String>();
		 int len=s.length();
		 if(len<4 || len>12)
		 {
			 return result;
		 }
		 for(int a=1;a<=3;a++)
		 {
			 for(int b=1;b<=3;b++)
			 {
				 for(int c=1;c<=3;c++)
				 {
					 for(int d=1;d<=3;d++)
					 {
						 if(a+b+c+d==len )
						 {  //(a<256 && b<256 && c<256 && d<256))
							 String A=s.substring(0, a);
							 String B=s.substring(a, a+b);
							String C= s.substring(a+b, a+b+c);
							String D=s.substring(a+b+c, a+b+c+d);
							 
								System.out.println("a"+s.substring(0, a)); 
								System.out.println("b"+s.substring(a, a+b)); 
								System.out.println("c"+s.substring(a+b, a+b+c)); 
								System.out.println("d"+s.substring(a+b+c, a+b+c+d)); 
								if (Integer.valueOf(A) <= 255
                                        && Integer.valueOf(B) <= 255
                                        && Integer.valueOf(C) <= 255
                                        && Integer.valueOf(D) <= 255) 
								{
                                    StringBuilder sb = new StringBuilder();
                                    result.add(sb.append(A).append(".").append(B).append(".").append(C).append(".").append(D).toString());
						 }
						 }
					 }
				 }
			 }
		 }
	       return  result;
	    }
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String s="2552551113";
		System.out.println(restoreIpAddresses(s));
		

	}

}
