
public class intToRoman 
{
	  public static String intToRoman(int num) 
	    {
	         int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	        StringBuilder result=new StringBuilder();
	        for(int i=0;i<values.length;i++)
	        {
	            while(values[i]<=num)
	            {
	                num=num-values[i];
	                result.append(strs[i]);
	                System.out.println(result);
	            }
	        }
	        return result.toString();
	    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int num=15;
		System.out.println(intToRoman(num));

	}

}
