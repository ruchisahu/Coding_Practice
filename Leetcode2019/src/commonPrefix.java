
public class commonPrefix
{
	 public static String longestCommonPrefix(String[] strs)
	    {
	        if(strs==null || strs.length==0  ) return "";
	         if(strs.length==1) return strs[0];
	        String s=strs[0];
	        for(int i=1;i<strs.length;i++)
	        {
	            int p=0;
	            int q=0;
	            while(q<s.length() && p<strs[i].length())
	            {
	                if(strs[i].charAt(p)==s.charAt(q))
	                {
	                    p++;
	                    q++;
	                }
	                else
	                    break;
	            }
	            s=s.substring(0,p);
	        }
	        return s;
	    }
	public static void main(String[] args) 
	{
		String[] strs= {"flower","flow","fl"};
		System.out.println(longestCommonPrefix(strs));

	}

}
