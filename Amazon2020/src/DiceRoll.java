/*
 You have d dice, and each die has f faces numbered 1, 2, ..., f.

Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.
 
Example 1:
Input: d = 1, f = 6, target = 3
Output: 1
Explanation: 
You throw one die with 6 faces.  There is only one way to get a sum of 3.
Example 2:
Input: d = 2, f = 6, target = 7
Output: 6
Explanation: 
You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
 */

import java.util.*;

public class DiceRoll
{
	
	
	    static int MOD = 1000000000 + 7;
	    static Map<String, Integer> memo = new HashMap<>();
	    public static int numRollsToTarget(int d, int f, int target)
	    {
	        if (d == 0 && target == 0) {
	            return 1;
	        }
	        if (d == 0 || target == 0) {
	            return 0;
	        }
	        String str = d + " " + target;
	        if (memo.containsKey(str)) {
	            return memo.get(str);
	        }
	        int res = 0;
	        for (int i = 1; i <= f; i++) {
	            if (target >= i) {
	               res = (res + numRollsToTarget(d - 1, f, target - i)) % MOD;  //%M  to avoid overflow
	             //   res = (res + numRollsToTarget(d - 1, f, target - i)) ;
	            } else {
	                break;
	            }
	        }
	        memo.put(str, res);
	        return res;
	    }
	    
	    /////
	   static  long[][] dp;
	    public static int numRollsToTarget1(int d, int f, int t) {
	        dp = new long[d + 1][t + 1];
	        return (int) dfs(d, f, t);
	    }
	    private static long dfs(int d, int f, int t) {
	        if (d < 0 || t < 0 || t < d || t > f * d)
	        	return 0;
	        if (dp[d][t] > 0) return dp[d][t];
	        if (t == d || t == f * d) {
	            dp[d][t] = 1;
	            return 1;
	        }
	        for (int i = 1; i <= f; i++) {
	            dp[d][t] += dfs(d - 1, f, t - i);
	        }
	        dp[d][t] %= (long) (Math.pow(10, 9) + 7);
	        return dp[d][t];
	    }
	
////
	    
	    public static int diceHelper(int source, int target){
	 	   if(source == target) return 0;
	 	   else if(source+target == 7) return 2;
	 	   else return 1;
	    }

	    public static int rollDice(int[] dice){
	 	   int rolls = Integer.MAX_VALUE;
	 	   for(int i=0;i<dice.length;++i){
	 		   int tmp = 0;
	 		   for(int j=0;j<dice.length;++j)
	 			   tmp+=diceHelper(dice[i],dice[j]);
	 		   if(tmp<rolls)
	 			   rolls = tmp;
	 	   }
	 	   return rolls;
	    }
	public static void main(String[] args) {
		System.out.println(numRollsToTarget(2, 6, 7));
		System.out.println(numRollsToTarget1(2, 6, 7));
		int[] dice= {1,2,3,4,5,6,7};
		System.out.println(rollDice(dice));

	}

}
