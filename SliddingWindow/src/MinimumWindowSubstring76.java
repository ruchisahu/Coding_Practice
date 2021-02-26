
public class MinimumWindowSubstring76 {
	 public static String minWindow(String s, String t) {
	        if(s.isEmpty()) return "";
	        int [] map = new int[128];
	        for (char c : t.toCharArray()) {
	          map[c]++;
	        }
	        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
	        while (end < s.length()) {
	          final char c1 = s.charAt(end);
	          if (map[c1] > 0) counter--;
	          map[c1]--;
	          end++;
	          while (counter == 0) {
	            if (minLen > end - start) {
	              minLen = end - start;
	              minStart = start;
	            }
	            final char c2 = s.charAt(start);
	            map[c2]++;
	            if (map[c2] > 0) counter++;
	            start++;
	          }
	        }

	        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	 }
	 
	 //trying bruteforce //time limit exceed
	 public static String minWindow1(String s, String t) {
		 int n=s.length();
	        int m=t.length();
	        if(s.isEmpty() && n<m) return "";
	        
	        int result=Integer.MAX_VALUE;
	        String resultval="";
	        
	        int diff=n-m;
	        for(int i=0;i<n;i++) {
	        	String str=s.substring(i,n);
	        	String common=CommonString(str,t);
	        	if(common!=null && common.length()<result) {
	        		resultval=common;
	        		result=resultval.length();
	        	}
	        }
			return resultval;
	        }

	private static String CommonString(String s, String t) {
		 int[] need = new int[128];
	        for(char c : t.toCharArray()) need[c]++;
	        char[] a = s.toCharArray();
	        int r = 0, l = 0, missing = t.length();
	
		 while(r < s.length())
		 {
	            if(need[a[r]] > 0) missing --;
	            need[a[r]]--;
	            r ++;
	            if(missing == 0)return s.substring(l, r);
		 }
		return null;
	
		 }

	public static void main(String[] args) {
		 String s = "DOBECODEBANC";
		 String t = "ABC";
		 System.out.println(minWindow(s,t));
		 
		// System.out.println("test:  "+minWindow1(s,t));
		 
		 String s1 = "A";
		 String t1 = "A";
	//	 System.out.println("test:  "+minWindow1(s1,t1));
		 //"cabwefgewcwaefgcf"
		// "cae"
		 String s2 = "cabwefgewcwaefgcf";
		 String t2 = "cae";
	//	 System.out.println("test:  "+minWindow1(s2,t2));  //"cwae"

	}

}
