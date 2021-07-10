
// Java implementation of the above approach

public class GFG{

// Function to calculate the Z-array for the given string
static void getZarr(String str, int n, int Z[])
{
	int L, R, k;

	// [L, R] make a window which matches with prefix of s
	L = R = 0;
	for (int i = 1; i < n; ++i) {
		if (i > R) {
			L = R = i;
			while (R < n && str.charAt(R - L) == str.charAt(R))
				R++;
			Z[i] = R - L;
			R--;
		}
		else {

			k = i - L;
			if (Z[k] < R - i + 1)
				Z[i] = Z[k];

			// For example str = "aaaaaa" and i = 2, R is 5,
			// L is 0
			else {
				// else start from R and check manually
				L = i;
				while (R < n && str.charAt(R - L) == str.charAt(R))
					R++;
				Z[i] = R - L;
				R--;
			}
		}
	}
}

// Function to return the similarity sum
static int sumSimilarities(String s, int n)
{
	int Z[] = new int[n] ;

	// Compute the Z-array for the given string
	getZarr(s, n, Z);

	int total = n;

	// Summation of the Z-values
	for (int i = 1; i < n; i++)
		total += Z[i];

	return total;
}

// Driver code
public static void main(String []args)
{
	String s = "abcabcd";
	int n = s.length();

	System.out.println(sumSimilarities(s, n));
}
// This code is contributed by Ryuga
}
