//https://leetcode.com/problems/integer-break/
public class IntegerBreak {
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


	public static void main(String[] args) {
		System.out.println(integerBreak(10));

	}

}
