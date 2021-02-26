//think about if given sum=0 is possible -->true but if val=0 no element given sum is greater than 0 is not possible.
/*
   0 1 2 3--->sum
0  T F F F
1  T
2  T
3  T
*/
public class SubsetSum {
	 
		static boolean isSubsetSum(int set[], int n, int sum) 
		{ 
			boolean subset[][] = new boolean[sum + 1][n + 1]; 

			// If sum is 0, then answer is true 
			for (int i = 0; i <= n; i++) subset[0][i] = true; 
			for (int i = 1; i <= sum; i++) 	subset[i][0] = false; 
 
			for (int i = 1; i <= sum; i++) { 
				for (int j = 1; j <= n; j++) { 
					subset[i][j] = subset[i][j - 1]; 
					if (i >= set[j - 1])	subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1]; 
				} 
			} 

			
		/*	for (int i = 0; i <= sum; i++) 
			{ 
			for (int j = 0; j <= n; j++) 
				System.out.println (subset[i][j]); 
			} 
			*/

			return subset[sum][n]; 
		} 

		/* Driver program to test above function */
		public static void main(String args[]) 
		{ 
			int set[] = { 3, 34, 4, 12, 5, 2 }; 
			int sum = 9; 
			int n = set.length; 
			if (isSubsetSum(set, n, sum) == true) 
				System.out.println("Found a subset"	+ " with given sum"); 
			else
				System.out.println("No subset with"	+ " given sum"); 
		} 
	} 

	