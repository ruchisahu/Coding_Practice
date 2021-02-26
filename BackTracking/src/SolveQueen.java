import java.util.ArrayList;
import java.util.List;

public class SolveQueen {
	public static List<List<String>> solveNQueens(int n) 
    {
        char[][] board=new char[n][n];
        for(int i=0;i <n ;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
                
            }
        }
        List<List<String>> res=new ArrayList<List<String>>();
                dfs(board,0,res);
        return res;
    }
    static void dfs(char[][] board,int row,List<List<String>> res)
    {
        if(row==board.length)
        {
            res.add(construct(board));
        return;
        }
        for(int col=0;col <board.length;col++)
        {
            if(valid(board,row,col))
            {
                board[row][col]='Q';
                dfs(board,row+1,res);
                board[row][col]='.';
            }
        }
    }
    private static boolean valid(char[][] board, int row, int col)
    {
       for(int i=0; i<row;i++)
       {
           if(board[i][col]=='Q')
           {
               return false;
           }
       }
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++)
        {
            if(board[i][j]=='Q')
                return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) 
        {
            if (board[i][j] == 'Q') 
                return false;
        }
        return true;
    }
    private static List<String> construct(char[][] board)
    {
        List<String> path =new ArrayList<>();
        for(int i=0;i<board.length;i++)
        {
            path.add(new String(board[i]));
        }
        return path;
    }
public static void main(String[] args) {
	solveNQueens(4);
}

}
