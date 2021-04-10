//O(n)
public class SurroundedRegions130 {
	public void solve(char[][] board) {
        int m = board.length - 1;
        int n = board[0].length - 1;
        
        for(int i = 0; i <= m; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                if(i == 0 || i == m || j == 0 || j == n)
                    if(board[i][j] == 'O')
                        dfs(board, i, j, m, n);
            }
        }
        /*
         * improved version
         * for (int i = 0; i < width; i++) {
            dfs(board, 0, i);
            dfs(board, height - 1, i);
        }
        for (int i = 0; i < height; i++) {
            dfs(board, i, 0);
            dfs(board, i, width - 1);
        }
         * 
         * 
         */
        
        for(int i = 0; i <= m; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                if(board[i][j] == 'F')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }
    
    public void dfs(char[][] board, int i, int j, int m, int n)
    {
        if(i < 0 || i > m || j < 0 || j > n || board[i][j] == 'X' || board[i][j] == 'F')
            return;
        
        board[i][j] = 'F';
        dfs(board, i+1, j, m, n);
        dfs(board, i, j+1, m, n);
        dfs(board, i-1, j, m, n);
        dfs(board, i, j-1, m, n);
    }
	public static void main(String[] args) {
		SurroundedRegions130 re=new SurroundedRegions130();
		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		for(int i = 0; i < board.length; i++)
        {
            
            	System.out.println(board[i]);
         }
		re.solve(board);
		System.out.println(".........output..................");
		for(int i = 0; i < board.length; i++)
        {
            
            	System.out.println(board[i]);
         }

	}

}
