import java.util.ArrayList;
import java.util.List;

public class wordsearch212 {
	public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words)
            if (exist(board, word))
                result.add(word);

        return result;
    }

    private static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (board[i][j] == word.charAt(0) && dfsExist(board, word, i, j, 0, visited)) 
                    return true;
            }
        }

        return false;
    }
    
    private static boolean dfsExist(char[][] board, String word, int i, int j, int position, boolean[][] visited) {
		// check if we found word if the postion == word.length()  return true.
        if (position == word.length())
            return true;
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && !visited[i][j] && board[i][j] == word.charAt(position)) {
            visited[i][j] = true;
            boolean result = (dfsExist(board, word, i, j + 1, position + 1, visited) ||
                    dfsExist(board, word, i + 1, j, position + 1, visited) ||
                    dfsExist(board, word, i - 1, j, position + 1, visited) ||
                    dfsExist(board, word, i, j - 1, position + 1, visited));
            visited[i][j] = false; // back track
            return result;
        } else return false;
    }
	public static void main(String[] args) {
		
				
		String[] words= new String[]{"oath","pea","eat","rain"};
		char[][] board= {{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}};
		System.out.println(findWords(board,words));

	}

	

}
