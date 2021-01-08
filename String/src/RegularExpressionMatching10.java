
public class RegularExpressionMatching10 {
	public static boolean isMatch(String s, String p) {
        return isMatch(s, s.length()-1 ,p, p.length()-1);
    }
    
    private static boolean isMatch(String s, int i1, String p, int i2)
    {
        if (i1 == -1 && i2 == -1) return true;
        else if (i2 == -1) return false;
        
        if (i1 >= 0 && (p.charAt(i2) == '.' || p.charAt(i2) == s.charAt(i1)))
        {
            return isMatch(s, i1-1, p, i2-1);
        }
		else if (p.charAt(i2) == '*')
        {
            char ch = p.charAt(i2-1);
            boolean isDot = ch == '.';

			// If matching character or dot character try to match remaing string for all possibilities
            for (int j = i1; j>=0 && (isDot || s.charAt(j) == ch); j--) 
            {
                if (isMatch(s, j-1, p, i2-2))
                    return true;
            }

            return isMatch(s, i1, p, i2-2); // Extra case where we want to not check the repeating character in s
        }
        else
        {
            return false;
        }
    }
    //dp sol
    public static boolean isMatchDp(String s, String p) {
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
		//"aab", p = "c*a*b"
		String s="aab";
		String p="c*a*b";
		System.out.println(isMatch(s,p));  //true 
		System.out.println(isMatchDp(s,p));

	}

}
