
public class minPartition {
	
	
		// Partition the set S into two subsets S1, S2 such that the
		// difference between the sum of elements in S1 and the sum
		// of elements in S2 is minimized
		public static int minPartition(int[] S, int n, int S1, int S2)
		{
			// base case: if list becomes empty, return the absolute
			// difference between two sets
			if (n < 0) {
				return Math.abs(S1 - S2);
			}

			// Case 1. include current item in the subset S1 and recur
			// for remaining items (n - 1)
			int inc = minPartition(S, n - 1, S1 + S[n], S2);

			// Case 2. exclude current item from subset S1 and recur for
			// remaining items (n - 1)
			int exc = minPartition(S, n - 1, S1, S2 + S[n]);

			return Integer.min(inc, exc);
		}

		// main function
		public static void main(String[] args)
		{
			// Input: set of items
			int[] S = { 1,6,11,5 };

			System.out.println("The minimum difference is "
					+ minPartition(S, S.length - 1, 0, 0));
		}
	
}
