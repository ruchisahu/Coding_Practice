/*
[2nd bit, 1st bit] = [next state, current state]

- 00(0)  dead (next) <- dead (current)
- 01(1)  dead (next) <- live (current)
- 10(2)  live (next) <- dead (current)
- 11(3)  live (next) <- live (current)
 */
public class GameOfLife {
    public static int[][] gameOfLife(int[][] board){
        if(board == null || board.length == 0 || board[0].length == 0) return board;

        int row = board.length, col = board[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int lives = getLives(i,j,board);
                // cur(00) => next(01)
                if(board[i][j] == 0 && lives == 3){
                    board[i][j] = 2;
                }
                // cur(01) => next(11)
                if(board[i][j] == 1 && lives >= 2 && lives <= 3){
                    board[i][j] = 3;
                }
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                board[i][j] >>= 1;
            }
        }
        return board;
    }

    public static int getLives(int i, int j, int[][] board){
        int lives = 0;
        for(int x = Math.max((i - 1),0); x <= Math.min((i + 1),board.length - 1); x++){
            for(int y = Math.max((j - 1),0); y <= Math.min((j + 1),board[0].length - 1); y++){
                lives += board[x][y] & 1;

                if(i == 0 && j == 0){
                    System.out.println("xy:" + String.valueOf(board[x][y]));
                    System.out.println("bit:" + String.valueOf(board[x][y] & 1));
                    System.out.println("lives:" + String.valueOf(lives));
                }
            }
        }


        lives = lives - board[i][j] & 1;

        return lives;
    }

    public static void main(String args[]){
        //int[][] board = new int[][]{{0,1,0},{0,1,1},{1,1,1},{0,0,0}};
        //System.out.println(gameOfLife(board));
        System.out.println(0 & 0);
    }

}
