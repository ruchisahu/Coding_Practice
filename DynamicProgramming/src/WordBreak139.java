import java.util.*;

public class WordBreak139 {
	public static boolean wordBreak(String s, List<String> wordDict) {
	      boolean[] all=new boolean[s.length()+1];
	    	all[0]=true;
	    	for(int i=1;i<=s.length();i++)
	    	{
	    		for(int j=0;j<i; j++)
	    		{
	    			if(all[j] && wordDict.contains(s.substring(j, i)))
	    			{
	    				System.out.println(s.substring(j, i));
	        			all[i] = true;
	        			System.out.println(i+"="+all[i]);
	    			break;
	    			}
	    		}
	    	}
	        return all[s.length()];  
	    }
	public static void main(String[] args) {
		String s="leetcode";
		List<String> wordDic=new ArrayList<String>();
		wordDic.add("leet");
		wordDic.add("code");
		wordBreak(s, wordDic);

	}

}
