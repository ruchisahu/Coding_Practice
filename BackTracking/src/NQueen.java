import java.util.*;
public class NQueen {

	static int N = 4; 
	static int []ld = new int[30]; 

	static int []rd = new int[30]; 
	static int []cl = new int[30]; 

	/* A utility function to print solution */
	static void printSolution(int board[][]) 
	{ 
		for (int i = 0; i < N; i++) 
		{ 
			for (int j = 0; j < N; j++) 
				System.out.printf(" %d ", board[i][j]); 
			System.out.printf("\n"); 
		} 
	} 

	/* A recursive utility function to solve N 
	Queen problem */
	static boolean solveNQUtil(int board[][], int col) 
	{ 
		if (col >= N) 
			return true; 

		for (int i = 0; i < N; i++) 
		{ 
			
			if ((ld[i - col + N - 1] != 1 && 
				rd[i + col] != 1) && cl[i] != 1) 
			{ 
				/* Place this queen in board[i][col] */
				board[i][col] = 1; 
				ld[i - col + N - 1] = 
				rd[i + col] = cl[i] = 1; 

				/* recur to place rest of the queens */
				if (solveNQUtil(board, col + 1)) 
					return true; 

				board[i][col] = 0; // BACKTRACK 
				ld[i - col + N - 1] = 
				rd[i + col] = cl[i] = 0; 
			} 
		} 

		/* If the queen cannot be placed in any row in 
			this colum col then return false */
		return false; 
	} 
	
	static boolean solveNQ() 
	{ 
		int board[][] = {{ 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0 }}; 

		if (solveNQUtil(board, 0) == false) 
		{ 
			System.out.printf("Solution does not exist"); 
			return false; 
		} 

		printSolution(board); 
		return true; 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 
		solveNQ(); 
	} 
	} 

