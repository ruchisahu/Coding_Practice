import java.util.PriorityQueue;

public class ShortestPathwithObstracle1293 {
	class Node implements Comparable<Node>{
        int row;
        int col;
        int dist;
        int k;
        int manhattan;

        Node( int row, int col, int dist, int k, int m, int n ){
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.k = k;
            manhattan = Math.abs( row - m ) + Math.abs( col - n );
        }

        @Override
        public int compareTo(Node o)
        {
            return this.manhattan + this.dist - o.manhattan - o.dist;
        }
    }
   public int shortestPath(int[][] grid, int k) {
	   int m = grid.length;
       int n = grid[0].length;

       int min = Integer.MAX_VALUE;
       PriorityQueue<Node> steps = new PriorityQueue<>();
       int[][][]visited = new int[m][n][k+1];
       Node begin = new Node( 0, 0, 0, k, m, n );
       steps.add( begin );

       while( !steps.isEmpty() ){
           Node step = steps.poll();

           if( step.row == m - 1 && step.col == n - 1 )
               return step.dist;


           visited[step.row][step.col][step.k] = 1;

           if( grid[step.row][step.col] == 1 ){
               if( step.k == 0 )
                   continue;
               else
                   step.k--;
           }

           if( isValid( step.row - 1, step.col, m, n ) ){
               if( visited[step.row - 1][step.col][step.k] != 1 )
                   steps.add( new Node( step.row - 1, step.col, step.dist + 1, step.k, m, n ) );
           }
           if( isValid( step.row + 1, step.col, m, n ) ){
               if( visited[step.row + 1][step.col][step.k] != 1 )
                   steps.add( new Node( step.row + 1, step.col, step.dist + 1, step.k, m, n ) );
           }
           if( isValid( step.row, step.col - 1, m, n ) ){
               if( visited[step.row][step.col - 1][step.k] != 1 )
                   steps.add( new Node( step.row, step.col - 1, step.dist + 1, step.k, m, n ) );
           }
           if( isValid( step.row, step.col + 1, m, n ) ){
               if( visited[step.row][step.col + 1][step.k] != 1 )
                   steps.add( new Node( step.row, step.col + 1, step.dist + 1, step.k, m, n ) );
           }
       }

       return -1;
   }

   private boolean isValid(int r, int c, int m, int n){
       if( r < 0 || c < 0 || r >= m || c >= n )
           return false;
       return true;
   }

	public static void main(String[] args) {
		ShortestPathwithObstracle1293 s=new ShortestPathwithObstracle1293();
		int[][] A = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
		System.out.println(s.shortestPath(A,1));     //6

	}

}
