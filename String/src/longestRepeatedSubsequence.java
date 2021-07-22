
public class longestRepeatedSubsequence {

	public static void main(String[] args) {
		String X = "ATACTCGGA";
		 
        System.out.print("The length of the longest repeating subsequence is " +
                LRSLength(X));
	}

	private static int LRSLength(String x) {
		int len=x.length();
		int[][]dp=new int[len+1][len+1];
		
		for(int i=1;i<=len;i++) {
			for(int j=1;j<=len;j++) {
				if(x.charAt(i-1)==x.charAt(j-1) && i!=j) {
					dp[i][j]=dp[i-1][j-1]+1;
					System.out.println(i+"  "+j+"  "+dp[i][j]);
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
					System.out.println(i+"  "+j+"  "+dp[i][j]);
				}
			}
		}
		return dp[len][len];
	}

	

}
