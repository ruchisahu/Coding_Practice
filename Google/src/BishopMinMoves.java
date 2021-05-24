import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/discuss/interview-question/algorithms/125404/number-of-moves-required-to-move-a-bishop-from-starting-position-to-ending-position
public class BishopMinMoves {
	public static int findMinMoves(int[][] board, int[]start, int[]end){
		   int x1=start[0];
		   int y1=start[1];
		   int x2=end[0];
		   int y2=end[1];
		   
	       if (isWhite(x1,y1) != isWhite(x2,y2)) return -1;
	       else if (x1==x2 && y1==y2) return 0;
	       else if (Math.abs(x1-x2) == Math.abs(y1-y2)) return 1;
	       else return 2;
	}

	private static boolean isWhite(int x, int y){
	     return x%2 == y%2;
	}
	
	//sol2: single move 
	static int[][] dirs = new int[][]{{-1,1},{1,1},{1,-1},{-1,-1}};
    public static int findMinMoves1(int[][] board, int[] start, int[] end){
        if(board == null || board.length == 0 || board[0].length == 0) return -1;

        int row = board.length, col = board[0].length;
        int count = 0;
        boolean[][] seen = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();

        q.add(start);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] index = q.poll();
                int x = index[0];
                int y = index[1];

                if(x == end[0] && y == end[1]){
                    return count + 1;
                }

                for(int[] dir : dirs){
                    int nextx = x + dir[0];
                    int nexty = y + dir[1];

                    if(nextx >= 0 && nextx < row && nexty >= 0 && nexty < col){
                        if(!seen[nextx][nexty]){
                            q.add(new int[]{nextx,nexty});
                            seen[nextx][nexty] = true;
                        }
                    }
                }

            }
            count++;
        }
        return -1;
    }

	public static void main(String[] args) {
		 int[][] board = new int[8][8];
	        int[] start = new int[]{5,1};
	        int[] end = new int[]{4,6};

	        System.out.println(findMinMoves(board,start,end));
	        
	        int[] end1 = new int[]{0,6};
	        System.out.println(findMinMoves(board,start,end1));

	}

}
