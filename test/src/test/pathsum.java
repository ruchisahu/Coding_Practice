package test;

public class pathsum {
	static int maxSum=Integer.MAX_VALUE;
    public static int minPathSum(int[][] grid) {
      
        int sum=grid[0][0];
        helper(grid,0,0,sum);
        return maxSum;
    }
    public static void helper(int[][]grid,int i,int j,int sum){
          int n=grid.length;
        int m=grid[0].length;
        if(i==n-1 && i==m-1){
            maxSum=Math.min(maxSum, sum);
        }
        if(i>=n-2 &&j>=m-2 && i<0 && j<0)return;
        
        System.out.println("i  "+i+"   "+j);
        
        helper(grid,i+1,j,sum+grid[i+1][j]);
 
        helper(grid,i,j+1,sum+grid[i][j+1]);
    }

	public static void main(String[] args) {
		int[][] grid ={{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(grid));

	}

}
