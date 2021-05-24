
public class TicTacToe {
	private char[][] board;
    private static char X = 'X';
    private static char O = 'O';
    private int size;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new char[n][n];
        size = n;
    }

    public int move(int row, int col, int player) {
        char c;
        if (player == 1) {
            c = X;
        } else {
            c = O;
        }
        if (board[row][col] != 0) {
            // throw error, occupied
            return 0;
        }
        board[row][col] = c;

        if (hasWon(row, col, size, c)) {
            return player;
        }
        return 0;
    }

    private boolean hasWon(int row, int col, int n, char c) {

        // check horizontal
        boolean rowLine = true;
        for (int i = 0; i < n; i++) {
            rowLine = rowLine && (board[i][col] == c);
        }
        // check vertical
        boolean colLine = true;
        for (int j = 0; j < n; j++) {
            colLine = colLine && (board[row][j] == c);
        }
        // check diagonal
        if (row + col == n - 1 || row == col) {
            boolean diagLine1 = true;
            boolean diagLine2 = true;
            for (int j = 0; j < n; j++) {
                diagLine1 = diagLine1 && (board[j][j] == c);
            }
            for (int j = 0; j < n; j++) {
                diagLine2 = diagLine2 && (board[n - 1 - j][j] == c);
            }
            return rowLine || colLine || diagLine1 || diagLine2;
        } else {
            return rowLine || colLine;
        }
    }



	public static void main(String[] args) {
		TicTacToe toe=new TicTacToe(3);
		toe.move(0, 0, 1);
		toe.move(0, 2, 2);
		toe.move(2, 2, 1);
		toe.move(1, 1, 2);
		toe.move(2, 0, 1);
		toe.move(1, 0, 2);
		System.out.println(toe.move(2, 1, 1));
		
		
		
		

	}

}
