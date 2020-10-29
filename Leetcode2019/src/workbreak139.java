import java.util.ArrayList;
import java.util.List;

public class workbreak139
{
	public static boolean wordBreak(String s, List<String> wordDict) {
	      boolean[] all=new boolean[s.length()+1];
	    	all[0]=true;
	    	for(int i=1;i<=s.length();i++)
	    	{
	    		for(int j=0;j<i; j++)
	    		{
	    			if(all[j] && wordDict.contains(s.substring(j, i)))
	    			{
	    				//System.out.println(s.substring(j, i));
	        			all[i] = true;
	        			//System.out.println(i+"="+all[i]);
	    			break;
	    			}
	    		}
	    	}
	        return all[s.length()];  
	}     
     
	public static void main(String[] args)
	{
		String s="leetcode";
		List<String> Dict=new ArrayList<String>();
		//Dict.add("leet");
		Dict.add("code");
		Dict.add("codewwe");
		// TODO Auto-generated method stub
		System.out.println(wordBreak(s,Dict));

	}

}

