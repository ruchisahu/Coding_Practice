
public class JobScheduleBetaTesting {
	 public static int minDifficulty(int[] A, int D) {
	        int n = A.length, inf = Integer.MAX_VALUE, maxd;
	        if (n < D) return -1;
	        int[] dp = new int[n + 1];
	        for (int i = n - 1; i >= 0; --i)
	            dp[i] = Math.max(dp[i + 1], A[i]);
	        for (int d = 2; d <= D; ++d) {
	            for (int i = 0; i <= n - d; ++i) {
	                maxd = 0;
	                dp[i] = inf;
	                for (int j = i; j <= n - d; ++j) {
	                    maxd = Math.max(maxd, A[j]);
	                    dp[i] = Math.min(dp[i], maxd + dp[j + 1]);
	                }
	            }
	        }
	        return dp[0];
	    }
	 
	 private int bruteForceWithoutMemo(int[] jd, int pos, int d, int len)
	    {
	        if(d == 0 && pos == len) return 0;
	        if(d == 0 || pos == len) return Integer.MAX_VALUE;
	        
	        int currMax = jd[pos];
	        int val = Integer.MAX_VALUE;
	        
	        for(int i = pos; i < len; i++)
	        {
	            currMax = Math.max(jd[i], currMax);
	            int temp = bruteForceWithoutMemo(jd, i+1, d-1, len);
	            if(temp != Integer.MAX_VALUE) 
	            {
	                val = Math.min(val, currMax+temp);
	            }
	        }
	        
	        return val;
	    }
	    
	    private int topDownDp(int[] jd, int pos, int d, int len, int[][] dp)
	    {
	        if(d == 0 && pos == len) return 0;
	        if(d == 0 || pos == len) return Integer.MAX_VALUE;
	        if(dp[d][pos] != -1) return dp[d][pos];
	        
	        int currMax = jd[pos];
	        int val = Integer.MAX_VALUE;
	        
	        for(int i = pos; i < len; i++)
	        {
	            currMax = Math.max(jd[i], currMax);
	            int temp = topDownDp(jd, i+1, d-1, len, dp);
	            if(temp != Integer.MAX_VALUE) 
	            {
	                val = Math.min(val, currMax+temp);
	            }
	        }
	        
	        dp[d][pos] = val;
	        return val;
	    }
	    
	    private int bottomUpDp(int[] jd, int d)
	    {
	        int len = jd.length;
	        int[][] dp = new int[d][len];
	        
	        dp[0][0] = jd[0];
	        for(int i = 1; i < len; i++)
	        {
	            dp[0][i] = Math.max(dp[0][i-1], jd[i]);
	        }
	        
	        for(int i = 1; i < d; i++)
	        {
	            for(int j = i; j < len; j++)
	            {
	                int maxDiff = jd[j];
	                dp[i][j] = Integer.MAX_VALUE;
	                
	                for(int k= j ; k >= i; k--)
	                {
	                    maxDiff = Math.max(jd[k], maxDiff);
	                    
	                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k-1] + maxDiff);
	                }
	            }
	        }
	        
	        return dp[d-1][len-1];
	    }

	public static void main(String[] args) {
		int[] A= {6,5,4,3,2,1};
		int D=2;
		System.out.println(minDifficulty(A,D));

	}

}
