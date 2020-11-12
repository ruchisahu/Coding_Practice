import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/discuss/?currentPage=1&orderBy=newest_to_oldest&query=
//1391
public class PathinGrid {
	//sol1
	 public static boolean hasValidPath1(int[][] grid) {
	        int rows = grid.length , cols = grid[0].length;
	        boolean[][] vis = new boolean[rows][cols];
	        Map<Integer,Set<Character>> map = new HashMap<>();
	        map.put(1,new HashSet<>(Arrays.asList('L','R')));
	        map.put(2,new HashSet<>(Arrays.asList('U','D')));
	        map.put(3,new HashSet<>(Arrays.asList('R','U')));
	        map.put(4,new HashSet<>(Arrays.asList('L','U')));
	        map.put(5,new HashSet<>(Arrays.asList('R','D')));
	        map.put(6,new HashSet<>(Arrays.asList('L','D')));
	        return dfs(grid,0,0,rows,cols,map,'~',vis);
	    }
	    
	    private static boolean dfs(int[][] grid,int x,int y,int rows,int cols,Map<Integer,Set<Character>> map,char dir,boolean[][] vis){
	        if(x == rows || x < 0 || y == cols || y < 0 || vis[x][y] || dir != '~' && !map.get(grid[x][y]).contains(dir)) return false;
	        if(x == rows-1 && y == cols-1) return true;
	        vis[x][y] = true;
	        if(map.get(grid[x][y]).contains('L') && dfs(grid,x,y+1,rows,cols,map,'R',vis)) return true;
	        if(map.get(grid[x][y]).contains('R') && dfs(grid,x,y-1,rows,cols,map,'L',vis)) return true;
	        if(map.get(grid[x][y]).contains('U') && dfs(grid,x+1,y,rows,cols,map,'D',vis)) return true;
	        if(map.get(grid[x][y]).contains('D') && dfs(grid,x-1,y,rows,cols,map,'U',vis)) return true;
	        return false;
	    }
	//sol2
	  int[][][] dirs = {
              {{0, -1}, {0, 1}},
              {{-1, 0}, {1, 0}},
              {{0, -1}, {1, 0}},
              {{0, 1}, {1, 0}},
              {{0, -1}, {-1, 0}},
              {{0, 1}, {-1, 0}}
  };
  //the idea is you need to check port direction match, you can go to next cell and check whether you can come back.
  public boolean hasValidPath(int[][] grid) {
      int m = grid.length, n = grid[0].length;
      boolean[][] visited = new boolean[m][n];
      Queue<int[]> q = new LinkedList<>();
      q.add(new int[]{0, 0});
      visited[0][0] = true;
      while (!q.isEmpty()) {
          int[] cur = q.poll();
          int x = cur[0], y = cur[1];
          int num = grid[x][y] - 1;
          for (int[] dir : dirs[num]) {
              int nx = x + dir[0], ny = y + dir[1];
              if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) continue;
              //go to the next cell and come back to orign to see if port directions are same
              for (int[] backDir : dirs[grid[nx][ny] - 1])
                  if (nx + backDir[0] == x && ny + backDir[1] == y) {
                      visited[nx][ny] = true;
                      q.add(new int[]{nx, ny});
                  }
          }
      }
      return visited[m - 1][n - 1];
  }

	public static void main(String[] args) {
		int[][] grid = {{2,4,3},{6,5,2}};
				System.out.println(hasValidPath1(grid));

	}

}
