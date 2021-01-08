
public class MinimumWindowSubstring76 {
	 public static String minWindow(String s, String t) {
	        if(s.isEmpty()) return "";
	        int[] need = new int[128];
	        for(char c : t.toCharArray()) need[c]++;
	        char[] a = s.toCharArray();
	        int r = 0, l = 0, missing = t.length(), i = 0, j = 0;
	        while(r < s.length()){
	            if(need[a[r]] > 0) missing --;
	            need[a[r]]--;
	            r ++;
	            while(missing == 0){
	                if(j == 0 || (r - l) < (j - i)){
	                    j = r;
	                    i = l;
	                }
	                need[a[l]]++;
	                if(need[a[l]] > 0) missing++;
	                l++;
	            }
	        }
	        return s.substring(i, j);
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
		 String s = "ADOBECODEBANC";
		 String t = "ABC";
		// System.out.println(minWindow(s,t));
		 
		// System.out.println("test:  "+minWindow1(s,t));
		 
		 String s1 = "A";
		 String t1 = "A";
	//	 System.out.println("test:  "+minWindow1(s1,t1));
		 //"cabwefgewcwaefgcf"
		// "cae"
		 String s2 = "cabwefgewcwaefgcf";
		 String t2 = "cae";
		 System.out.println("test:  "+minWindow1(s2,t2));  //"cwae"

	}

}
