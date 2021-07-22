import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
/*
 * *Give you a 2-D matrix which you can started from (0, 0)
You can go up, left, right, down in 4-direction
return True if there has a strickly decreasing path can reach the (m-1, n-1). 
else return False
example1:
20, 100, 12,  11, 10
19, 100, 13, 100,  9
18, 100, 14, 100,  8
17, 16 , 15, 100,  7
return True
example2:
20, 100, 12,  11, 10
19, 100, 13, 100,  9
18, 100, 14, 100,  8
17, 100, 15, 100,  7
return False
 */
public class decreasingPath {
	public static void main(String[] args) {
        int[][] m1 = new int[][] { { 20, 100, 12,  11, 10 }, { 19, 100, 13, 100,  9 }, { 18, 100, 14, 100,  8 }, { 17, 16 , 15, 100,  7 } };
        if (new decreasingPath().problem(m1) != true)
            System.out.println("Wrong answer for #1");
 
        int[][] m2 = new int[][] { { 20, 100, 12,  11, 10 }, { 100, 100, 13, 100,  9 }, { 18, 100, 14, 100,  8 }, { 17, 100, 15, 100,  7 } };
        if (new decreasingPath().problem(m2) != false)
            System.out.println("Wrong answer for #2");    
    }
 
    public boolean problem(int[][] grid) {
    	 int m = grid.length;
         int n = grid[0].length;

         int[] dx = {-1,1,0,0};
         int[] dy = {0,0,-1,1};
         
         boolean[][] visited = new boolean[m][n];

         Queue<int[]> q = new LinkedList<>();
         q.add(new int[]{0,0});
         visited[0][0] = true;

         while (!q.isEmpty()) {
             int[] u = q.poll();
             if(u[0] == m-1 && u[1] == n-1) {
                 return true;
             }

             for (int i=0; i<4; i++) {
                 int nu = u[0] + dx[i];
                 int nv = u[1] + dy[i];

                 if (nu >= 0 && nu<m && nv>=0 && nv<n && !visited[nu][nv] && grid[nu][nv] < grid[u[0]][u[1]]) {
                     visited[nu][nv] = true;
                     q.add(new int[]{nu, nv});
                 }
             }
         }
         return false;
     }
    
}