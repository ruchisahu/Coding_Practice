
public class RegularExpression10 {
	  public static boolean isMatch(String s, String p) {
		  if (p == null || p.length() == 0) return (s == null || s.length() == 0);
	        
	        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
	        dp[0][0] = true;
	        for (int j=2; j<=p.length(); j++) {
	            dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2]; 
	        }
	        
	        for (int j=1; j<=p.length(); j++) {
	            for (int i=1; i<=s.length(); i++) {
	                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.') 
						dp[i][j] = dp[i-1][j-1];
	                else if(p.charAt(j-1) == '*')
	                    dp[i][j] = dp[i][j-2] || ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]); 
	            }
	        }
	        return dp[s.length()][p.length()];
	  }

	public static void main(String[] args) {
		String s="aab";
		String p="c*a*b";
		 System.out.println(isMatch(s, p));

	}

}