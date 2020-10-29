
public class RottingOranges994 {
	public static int orangesRotting(int[][] grid) {
		 int m = grid.length, n = grid[0].length;
		    for(int i = 0; i < m; i++) {
		      for(int j = 0; j < n; j++) {
		        if(grid[i][j] == 2) {
		          fill(i, j, grid, 2);
		        }
		      }
		    }
		    int max = 0;
		    for(int i = 0; i < m; i++) {
		      for(int j = 0; j < n; j++) {
		        if(grid[i][j] == 1) return -1;
		        else if(grid[i][j] > max) {
		          max = Math.max(grid[i][j], max);
		        }
		      }
		    }
		    return max == 0 ? max : max - 2;
		  }
		  
		  private static void fill(int r, int c, int[][] grid, int mins) {
		    if((grid[r][c] != 1 && grid[r][c] < mins) || grid[r][c] == 0) { 
			
		      return;
		    }
		    grid[r][c] = mins;
		    if(r > 0) fill(r - 1, c, grid, mins + 1);
	    if(r < grid.length - 1) fill(r + 1, c, grid, mins + 1);
		    if(c > 0) fill(r, c - 1, grid, mins + 1);
		    if(c < grid[0].length - 1) fill(r, c + 1, grid, mins + 1);
		  }
		

		  //sol2 try
		  public static int orangesRotting1(int[][] grid) {
			 int m = grid.length, n = grid[0].length;
			    for(int i = 0; i < m; i++) {
			      for(int j = 0; j < n; j++) {
			        if(grid[i][j] == 2) {
			          fill1(i, j, grid, 2);
			        }
			      }
			    }
			    int max = 0;
			    for(int i = 0; i < m; i++) {
			      for(int j = 0; j < n; j++) {
			        if(grid[i][j] == 1) 
			        	return -1;
			        else if(grid[i][j] > max) {
			          max = Math.max(grid[i][j], max);
			        }
			      }
			    }
			    return max == 0 ? max : max - 2;
			  }
			  
			  private static void fill1(int r, int c, int[][] grid, int mins) {
			   
			    grid[r][c] = mins;
			    if(r > 0 && (grid[r-1][c]==1) )
			    	fill1(r - 1, c, grid, mins + 1);
			    
			    if(r < grid.length - 1 && grid[r+1][c]==1)
			    	fill1(r + 1, c, grid, mins + 1);
			    
			    if(c > 0 && grid[r][c-1]==1)
			    	fill1(r, c - 1, grid, mins + 1);
			    
			    if(c < grid[0].length - 1 && grid[r][c+1]==1)
			    	fill1(r, c + 1, grid, mins + 1);
			  }
			
	public static void main(String[] args) {
		int[][] orange={{2,1,1},{1,1,0},{0,1,1}};
		int[][] orange2= {{2},{1},{1},{1},{2},{1},{1}};
		System.out.println(orangesRotting1(orange2));

	}

}
