import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/alphabet-board-path/

	 class BoardPoint
	 {
	        public int X;
	        public int Y;
	        public List<Character> Directions;

	        public BoardPoint(int x, int y)
	        {
					X = x;
					Y = y;
					Directions = new ArrayList<>();
	        }

	        public BoardPoint(int x, int y, List<Character> directions)
	        {            
	            Directions = directions;
	        }
	}

	 public class AlphabetBoardPath {
	
		 public String alphabetBoardPath(String target) {
	        
	            char[][] board = new char[][] { "abcde".toCharArray(), "fghij".toCharArray(), "klmno".toCharArray(), "pqrst".toCharArray(), "uvwxy".toCharArray(), "z".toCharArray() };

	            if (target == null || target.length() == 0)return null;
	            
	                
	            return BFS(board, target);
	        }

	        public String BFS(char[][] board, String target)
	        {
	            StringBuilder sb = new StringBuilder();
	            boolean[] visited = new boolean[26];
	            Queue<BoardPoint> q = new LinkedList<>();

	            int[][] directions = new int[][] { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
	            char[] chard = new char[] { 'L', 'U', 'R', 'D' };

	            q.add(new BoardPoint(0, 0));
	            visited[0] = true;

	            int nextchar = 0;
	            char d = target.charAt(nextchar);
	            nextchar++;

	            while (q.size() > 0)
	            {
	            	BoardPoint pair = q.poll();
	                if (board[pair.X][pair.Y] == d)
	                {
	                    q.clear();
	                    sb.append(new String(pair.Directions.toString()));
	                    sb.append('!');
	                    if (nextchar == target.length())
	                    {
	                        return sb.toString();
	                    }

	                    for (int i = 0; i < visited.length; i++)
	                    {
	                        visited[i] = false;
	                    }

	                    d = target.charAt(nextchar);
	    	            nextchar++;
	                    q.add(new BoardPoint(pair.X, pair.Y));
	                    continue;
	                }

	                for (int i = 0; i < directions.length; i++)
	                {
	                    int x = pair.X + directions[i][0];
	                    int y = pair.Y + directions[i][1];
	                    if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && !visited[board[x][y] - 'a'])
	                    {
	                        visited[board[x][y] - 'a'] = true;
	                        List<Character> pairDirections = pair.Directions;
	                        pairDirections.add(chard[i]);
	                        BoardPoint point = new BoardPoint(x, y, pairDirections);
	                        q.add(point);
	                    }
	                }
	            }
	            return null;
	        }
	


	public static void main(String[] args) {
		AlphabetBoardPath a=new AlphabetBoardPath();
		String target = "leet";
		System.out.println(a.alphabetBoardPath(target));

	}




}
