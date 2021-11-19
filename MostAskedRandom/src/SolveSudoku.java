// O(9^(n*n)). 
public class SolveSudoku {
public void solveSudoku(char[][] board) {
    
        
        solveSudoko(board);
    }
    public boolean solveSudoko(char board[][])
    {
       
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                if(board[i][j] == '.')
                {
                    for(int number = 1;number <= 9 ; number++)
                    {
                        if(isSafePlace(i,j,board,number) == true)
                        {
                            board[i][j] = (char)((number+48));
                            if(solveSudoko(board) == true)
                                return true;
                            else
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isSafePlace(int row,int col,char[][] board,int number)
    {
        
        //row Safe
        int i =0;
        int j = 0;
        while(j<board.length)
        {
            if(board[row][j] == (char)((number+48)))
                return false;
            j++;
        }
       
        i=0;
        while(i<board.length)
        {
            if(board[i][col] ==(char)((number+48)))
            return false;
            i++;
        }
       
        
        //gridSafe
        int rowStart = row - row%3;
        int colStart = col - col%3;
        for(i=rowStart;i<rowStart+3;i++)
        {
            for(j=colStart;j<colStart+3;j++)
            {
                if(board[i][j] == (char)((number+48)))
                    return false;
            }
        }
        return true;
        
    }

	public static void main(String[] args) {
		SolveSudoku s=new SolveSudoku();
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(s.solveSudoko(board));
		for(int i=0;i<board.length;i++) {
				System.out.println(board[i]);
			
		}
	}

}
