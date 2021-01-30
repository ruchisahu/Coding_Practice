package test;
//https://leetcode.com/discuss/interview-question/1002205/Amazon-or-SDE-1-or-Phone-screen
public class CoinChangePossible {
	public static boolean isPossible(int[] coins, int n) {
		
		boolean[] dp=new boolean[n+1];
		dp[0]=true;
		for(int coin:coins) {
			for(int i=1;i<=n;i++) {
				if(coin<=i) {
					dp[i]=dp[i] || dp[i-coin];
				}
			}
		}
		return dp[n];
		
	}

	public static void main(String[] args) {
		int[] coins= {4,6,11};
		int n=31;
		System.out.println(isPossible(coins,n));  //true
		int n1=9;
		System.out.println(isPossible(coins,n1));   //false

	}

}
