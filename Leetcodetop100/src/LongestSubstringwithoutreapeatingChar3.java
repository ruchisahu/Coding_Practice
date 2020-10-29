
public class LongestSubstringwithoutreapeatingChar3 {
	 public static int lengthOfLongestSubstring(String s) {
		 if(s==null)return 0;
		 int len=s.length();
		 boolean[] count =new boolean[256];
		 int max=0;
		 int end=0;
		 for(int i=0;i<len;i++)
		 {
			 while(count[s.charAt(i)])
			 {
				 count[s.charAt(end)]=false;
				 end++;
			 }
			 count[s.charAt(i)]=true;
			 max=Math.max(max, i-end+1);
		 }
		 return max;
	        
	    }

	public static void main(String[] args) {
		String s="abcabcbb";
		 System.out.println(lengthOfLongestSubstring(s));
		        
		    

	}

}
