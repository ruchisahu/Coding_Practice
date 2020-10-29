
public class EditDistance 
{

		static int min(int x,int y,int z) 
		{ 
			if (x <= y && x <= z) return x; 
			if (y <= x && y <= z) return y; 
			else return z; 
		} 

		static int editDistDP(String str1, String str2, int m, int n) 
		{ 
			// Create a table to store results of subproblems 
			int dp[][] = new int[m+1][n+1]; 
			for (int i=0; i<=m; i++) 
			{ 
				for (int j=0; j<=n; j++) 
				{ 
					
					if (i==0) 
						dp[i][j] = j; // Min. operations = j 
		
					else if (j==0) 
						dp[i][j] = i; // Min. operations = i 
		
					else if (str1.charAt(i-1) == str2.charAt(j-1)) 
						dp[i][j] = dp[i-1][j-1]; 
		
					else
						dp[i][j] = 1 + min(dp[i][j-1], // Insert 
										dp[i-1][j], // Remove 
										dp[i-1][j-1]); // Replace 
				} 
			} 

			return dp[m][n]; 
		} 

		

		public static void main(String args[]) 
		{ 
			String str1 = "sunday"; 
			String str2 = "saturday"; 
			System.out.println( editDistDP( str1 , str2 , str1.length(), str2.length()) ); 
		} 
	}
