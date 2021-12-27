/*
Leetcode 723 Candy Crush
 */
public class CandyCrush {
    public static int[][] candyCrush(int[][] board){
        if(board == null || board.length == 0 || board[0].length == 0) return board;

        int row = board.length, col = board[0].length;
        boolean stable = true;

        for(int i = 0; i < row; i++){
            for(int j = 0; j + 2 < col;){
                int target = Math.abs(board[i][j]);
                if(board[i][j] != 0 && Math.abs(board[i][j + 1]) == target && Math.abs(board[i][j + 2]) == target){
                    stable = false;
                    int k = j;
                    while(k < col && Math.abs(board[i][k]) == target){
                        board[i][k] = -target;
                        k++;
                    }
                    j = k;
                }
            }
        }

        for(int j = 0; j < col; j++){
            for(int i = 0; i + 2 < row;){
                int target = Math.abs(board[i][j]);
                if(board[i][j] != 0 && Math.abs(board[i + 1][j]) == target && board[i + 2][j] == target){
                    stable = false;
                    int k = i;
                    while(k < row && Math.abs(board[k][j]) == target){
                        board[k][j] = -target;
                        k++;
                    }
                    i = k;
                }
            }
        }

        if(!stable){
            for(int j = 0; j < col; j++){
                int i = row - 1, p = row - 1;
                while(i >= 0 && board[i][j] != 0){
                    if(board[i][j] > 0) {
                        board[p][j] = board[i][j];
                        p--;
                    }
                    i--;
                }

                while(p >= 0){
                    board[p][j] = 0;
                }
            }
        }

        return stable ? board : candyCrush(board);
    }

    public static void main(String args[]){
        int[][] arr = new int[][]{{110,5,112,113,114},
                {210,211,5,213,214},
                {310,311,3,313,314},
                {410,411,412,5,414},
                {5,1,512,3,3},
                {610,4,1,613,614},
                {710,1,2,713,714},
                {810,1,2,1,1},
                {1,1,2,2,2},
                {4,1,4,4,1014}};

        int[][] board = candyCrush(arr);

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.println(board[i][j]);
            }
        }
    }
}
