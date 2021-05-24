
public class TicTacToeGameWinner1275 {
	 public static String tictactoe(int[][] moves) {
         final int[] aRow = new int[3];
        final int[] aCol = new int[3];
        final int[] bRow = new int[3];
        final int[] bCol = new int[3];
        final int[] aDiag = new int[1];
        final int[] bDiag = new int[1];
        final int[] aDiagR = new int[1];
        final int[] bDiagR = new int[1];
        
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                if (win(aRow, aCol, aDiag, aDiagR, moves[i])) {
                    return "A";
                }
            }
            else {
                if (win(bRow, bCol, bDiag, bDiagR, moves[i])) {
                    return "B";
                }
            }
        }
        
        return moves.length == 9 ? "Draw" : "Pending";
    }
    
    private static boolean win(final int[] row, final int[] col, final int[] diag, final int[] diagR, final int[] move) {
        if (++row[move[0]] == 3) {
            return true; 
        }
        if (++col[move[1]] == 3) {
            return true; 
        }
        if (move[0] == move[1] && ++diag[0] == 3) {
            return true; 
        }
        if (move[0] + move[1] == 2 && ++diagR[0] == 3) {
            return true; 
        }
        return false; 
        
    }


	public static void main(String[] args) {
		int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
		System.out.println(tictactoe(moves));

	}

}
