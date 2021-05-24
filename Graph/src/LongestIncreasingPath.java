import java.util.*;

public class LongestIncreasingPath {
	//sol1 dfs
	   public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	   public static int longestIncreasingPath(int[][] matrix) {
	       if(matrix.length == 0) return 0;
	       int m = matrix.length, n = matrix[0].length;
	       int[][] cache = new int[m][n];
	       int max = 1;
	       for(int i = 0; i < m; i++) {
	           for(int j = 0; j < n; j++) {
	               int len = dfs(matrix, i, j, m, n, cache);
	               max = Math.max(max, len);
	           }
	       }   
	       return max;
	   }

	   public static int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
	       if(cache[i][j] != 0) return cache[i][j];
	       int max = 1;
	       for(int[] dir: dirs) {
	           int x = i + dir[0], y = j + dir[1];
	           if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
	           int len = 1 + dfs(matrix, x, y, m, n, cache);
	           max = Math.max(max, len);
	       }
	       cache[i][j] = max;
	       return max;
	   }
	   //sol2
	  
	    private boolean ispeak(int[][] matrix, boolean[][] marked, int i, int j) {
	        if (i > 0 && !marked[i-1][j] && matrix[i-1][j] > matrix[i][j]) return false;
	        if (i < matrix.length-1 && !marked[i+1][j] && matrix[i+1][j] > matrix[i][j]) return false;
	        if (j > 0 && !marked[i][j-1] && matrix[i][j-1] > matrix[i][j]) return false;
	        if (j < matrix[0].length-1 && !marked[i][j+1] && matrix[i][j+1] > matrix[i][j]) return false;
	        return true;
	    }
	    public int longestIncreasingPath1(int[][] matrix) {
	        if (matrix.length == 0 || matrix[0].length == 0) return 0;
	        int len = 0;
	        LinkedList<int[]> queue = new LinkedList<>();
	        boolean[][] marked = new boolean[matrix.length][matrix[0].length];
	        for (int i = 0; i < matrix.length; i++) {
	            for (int j = 0; j < matrix[0].length; j++) {
	                if (ispeak(matrix, marked, i, j)) queue.add(new int[]{i, j});
	            }
	        }
	        while (!queue.isEmpty()) {
	            len++;
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                int[] p = queue.poll();
	                marked[p[0]][p[1]] = true;
	                for (int j = 0; j < 4; j++) {
	                    int r = p[0]+dirs[j][0], c = p[1]+dirs[j][1];
	                    if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && !marked[r][c] && ispeak(matrix, marked, r, c)) {
	                        if (matrix[r][c] != matrix[p[0]][p[1]]) queue.add(new int[]{r, c});
	                    }
	                }
	            }
	        }
	        return len;
	    }

	public static void main(String[] args) {
		 int[][] grid = new int[][]{{1,2,13,5},
             {11,10,9,6},
             {3,4,8,7},
             {12,14,15,16}};
         int[] start = new int[]{0,3};

System.out.println(longestIncreasingPath(grid));

	}

}
