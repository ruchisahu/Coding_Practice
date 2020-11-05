
public class IntegerBreak343 {
	  public static int integerBreak(int n) {
		  int[] dp = new int[n + 1];
	        dp[0] = 1;
	        int max = 0;
	        for(int i = 1; i < n; i++){
	            for(int j = i; j <= n; j++){
	                dp[j] = Math.max(dp[j], dp[j - i] * i);
	                if(j == n){
	                    if(max < dp[j])
	                        max = dp[j];
	                }
	            }
	        }
	        return max;
	    }
	  //sol2
	  public static  int integerBreak1(int n) {
	        if (n == 0) return 0;
	        int[] dp = new int[n + 1];
	        dp[0] = 1;
	        for (int i = 1; i < n; i++) {
	            for (int j = i; j <= n; j++) {
	                dp[j] = Math.max(dp[j], dp[j - i] * i);
	            }
	        }
	        return dp[n];
	    }

	public static void main(String[] args) {
		System.out.println(integerBreak(10));

	}

}
