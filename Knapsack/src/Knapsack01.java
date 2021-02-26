
public class Knapsack01 {
	/* A Naive recursive implementation 
	of 0-1 Knapsack problem */

		// A utility function that returns 
		// maximum of two integers 
		static int max(int a, int b) 
		{ 
			return (a > b) ? a : b; 
		} 

		// Returns the maximum value that 
		// can be put in a knapsack of 
		// capacity W 
		static int knapSack(int W, int wt[], int val[], int n) 
		{ 
			if (n == 0 || W == 0) return 0; 

			if (wt[n - 1] > W)return knapSack(W, wt, val, n - 1); 

			// Return the maximum of two cases: 
			// (1) nth item included 
			// (2) not included 
			else
				return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), 
					knapSack(W, wt, val, n - 1)); 
		} 
	/*	Complexity Analysis:

			Time Complexity: O(2^n).
			As there are redundant subproblems.
			Auxiliary Space :O(1).
			*/
		private int dp(int[] profits, int[] weights, int capacity, int index, int res) {
		    if (index == profits.length) return res;
		    if (weights[index] > capacity) return dp(profits, weights, capacity, index+1, res);
		    return Math.max(dp(profits, weights, capacity, index+1, res), dp(profits, weights, capacity-weights[index], index+1, res+profits[index]));
		  }
		static int knapSackDP(int W, int wt[], int val[], int n) 
	    { 
	        int i, w; 
	        int K[][] = new int[n + 1][W + 1]; 
	        for (i = 0; i <= n; i++) { 
	            for (w = 0; w <= W; w++) { 
	                if (i == 0 || w == 0) K[i][w] = 0; 
	                else if (wt[i - 1] <= w) 
	                    K[i][w] = Math.max( val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]); 
	                else
	                    K[i][w] = K[i - 1][w]; 
	            } 
	        } 
	  
	        return K[n][W]; 
	    } 
		/*
		 * Complexity Analysis:

Time Complexity: O(N*W).
where ‘N’ is the number of weight element and ‘W’ is capacity. As for every weight element we traverse through all weight capacities 1<=w<=W.
Auxiliary Space: O(N*W).
The use of 2-D array of size ‘N*W’.
		 */
		public static void main(String args[]) 
		{ 
			int val[] = new int[] { 60, 100, 120 }; 
			int wt[] = new int[] { 10, 20, 30 }; 
			int W = 50; 
			int n = val.length; 
			//System.out.println(knapSack(W, wt, val, n)); 
			
			int val1[] = new int[] {10,5,15,7,6,18,3}; 
			int wt1[] = new int[] {2,3,5,7,1,4,1}; 
			int W1 = 15; 
			int n1 = val1.length; 
			System.out.println(knapSack(W1, wt1, val1, n1)); 
			
			
		} 
	} 

