//https://leetcode.com/problems/bomb-enemy/
/*
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.
Example:
For the given grid
0 E 0 0
E 0 W E
0 E 0 0
return 3. (Placing a bomb at…
 */
		//https://massivealgorithms.blogspot.com/2016/06/leetcode-361-bomb-enemy.html
public class BombEnemy {
	public static int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        int rowCount = 0;
        int[] colCount = new int[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // start from first row, count the enemies in the current row between two walls
                // store it to avoid recompute
                if (j == 0 || grid[i][j-1] == 'W') {
                    rowCount = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') rowCount++;
                    }
                }
                // start from solumn, count the enemies in the current col between two walls
                if (i == 0 || grid[i-1][j] == 'W') {
                    colCount[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') colCount[j]++;
                    }
                }
                // if this is a position to place the bomb, get the current max
                if (grid[i][j] == '0') {
                    max = Math.max(max, rowCount + colCount[j]);
                }
            }
        }
        return max;
    }

//sol2
	 public static int maxKilledEnemies1(char[][] grid) {

	        if (grid == null || grid.length == 0)
	            return 0;

	        int ret=0;

	        for (int i=0; i<grid.length; i++) {
	            for (int j=0; j<grid[0].length; j++) {
	                if (grid[i][j] != '0')
	                    continue;
	                ret = Math.max(ret, countKilled(i, j, grid));                     
	            }
	        }        

	        return ret;

	    }

	    static int countKilled(int row, int col, char[][] grid) {
	        int ret=0;

	        for (int i=row; i<grid.length && grid[i][col] != 'W'; i++) {
	            if (grid[i][col] == 'E')
	                ret++;
	        }
	        for (int i=row; i>=0 && grid[i][col] != 'W'; i--) {
	            if (grid[i][col] == 'E')
	                ret++;
	        }
	        for (int i=col; i<grid[0].length && grid[row][i] != 'W'; i++) {
	            if (grid[row][i] == 'E')
	                ret++;
	        }
	        for (int i=col; i>=0 && grid[row][i] != 'W'; i--) {
	            if (grid[row][i] == 'E')
	                ret++;
	        }
	        return ret;
	    }
	    //sol3
	    public int maxKilledEnemies3(char[][] grid) {
	        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

	        int m = grid.length;
	        int n = grid[0].length;
	        int[][] dp = new int[m][n];

	        // from left to right
	        for (int i = 0; i < m; i++) {
	            int current = 0;
	            for (int j = 0; j < n; j++) 
	                current = process(grid, dp, i, current, j);
	        }
	        // from top to bottom
	        for (int j = 0; j < n; j++) {
	            int current = 0;
	            for (int i = 0; i < m; i++) 
	                current = process(grid, dp, i, current, j);
	        }
	        // from right to left
	        for (int i = 0; i < m; i++) {
	            int current = 0;
	            for (int j = n - 1; j >= 0; j--) 
	                current = process(grid, dp, i, current, j);
	        }
	        int ans = 0;
	        // from bottom to top
	        for (int j = 0; j < n; j++) {
	            int current = 0;
	            for (int i = m - 1; i >= 0; i--) {
	                current = process(grid, dp, i, current, j);
	                if (grid[i][j] == '0')  ans = Math.max(ans, dp[i][j]);
	            }
	        }
	        return ans;
	    }
	        private int process(char[][] c, int[][] dp, int i, int current, int j) {
	            if (c[i][j] == 'W') current = 0;
	            if (c[i][j] == 'E') current++;
	            dp[i][j] += current;
	            return current;
	        }
	public static void main(String[] args) {
		char[][] grid= {{'0', 'E', '0', '0'},{'E', '0', 'W' ,'E'},{'0', 'E', '0', '0'}};
		System.out.println(maxKilledEnemies1(grid));

	}

}
