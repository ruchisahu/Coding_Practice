package test;

public class Knapsack {
	
	static int knapSackDP(int W, int wt[], int val[], int n) 
    { 
        int i, w; 
        int K[][] = new int[n + 1][W + 1]; 
  
        // Build table K[][] in bottom up manner 
        for (i = 0; i <= n; i++) { 
            for (w = 0; w <= W; w++) { 
                if (i == 0 || w == 0) 
                    K[i][w] = 1; 
                else if (wt[i - 1] <= w) 
                    K[i][w] = Math.max( val[i - 1] *K[i - 1][w - wt[i - 1]], K[i - 1][w]); 
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
		int val[] = new int[] { 1, 2,3,4,5,6,7,8,9,10 }; 
		int wt[] = new int[] {1,2,3,4,5,6,7,8,9,10 }; 
		int W = 10; 
		int n = val.length; 
		System.out.println(knapSackDP(W, wt, val, n)); 
		
		
	} 
} 

