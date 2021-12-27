public class SearchWord {
    public static boolean isWord(char[][] board, String word){
        if(board == null || board.length == 0 || board[0].length == 0) return false;

        int row = board.length;
        int col = board[0].length;
        boolean[][] used = new boolean[board.length][board[0].length];

        for(int i = 0; i < row - 1; i++){
            for(int j = 0; j < col; j++){
                if(check(board, word.toCharArray(), used,0,i,j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(char[][] board, char[] word, boolean[][] used, int index, int row, int col){
        if(index == word.length) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if(used[row][col] == true || board[row][col] != word[index]) return false;

        used[row][col] = true;

        if(check(board,word,used,index+1,row+1,col)) return true;
        if(check(board,word,used,index+1,row-1,col)) return true;
        if(check(board,word,used,index+1,row,col+1)) return true;
        if(check(board,word,used,index+1,row,col-1)) return true;

        used[row][col] = false;

        return false;

    }

    public static void main(String args[]) {
        char[][] arr = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";

        boolean res = isWord(arr,word);
        System.out.println(res);
    }

}
