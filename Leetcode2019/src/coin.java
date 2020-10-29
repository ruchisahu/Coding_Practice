
public class coin 
{
	  
		  public static int change(int amount, int[] coins) {
		        int[] dp = new int[amount + 1];
		        dp[0] = 1;        
		        for (int j = 0; j < coins.length; j++) {
		            for (int i = 1; i <= amount; i++) {
		                if (i - coins[j] >= 0) {
		                    dp[i] += dp[i - coins[j]];
		                }
		            }
		        }
		        return dp[amount];
	  }
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int amount=5;
		int[] coins= {1,2};
		System.out.println(change(amount, coins));
	}

}
