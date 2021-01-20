import java.util.*;

public class maxFishInGrid {
	public static int maxFishInGrid(int[][] sea) {
		
	    int maxFish = 0;
	    ArrayList<Integer> result = new ArrayList<>();  
	    computeFish(sea, sea.length-1, sea[0].length-1, 0, result);
	    for(int a: result) {
	        maxFish = Math.max(maxFish, a);
	    }
	    return maxFish;
	}

	private static void computeFish(int[][] sea, int i, int j, int sum, ArrayList<Integer> result) {   
	    if(i == 0 && j == 0) {
	        result.add(sum+sea[i][j]);
	        return;
	    }
	    sum += sea[i][j];
	    if(i > 0 ) {
	        computeFish(sea, i-1, j, sum, result);
	    }
	    if(j > 0) {
	        computeFish(sea, i, j-1, sum, result);
	    }
	}
	
	public static int maxFishInGridDP(int[][] sea) {
		int n=sea.length;
		int m=sea[0].length;
		int[][]dp=new int[n+1][m+1];
		dp[0][0]=sea[0][0];
		for(int i=1;i<n;i++) {
			dp[i][0]=sea[i][0]+dp[i-1][0];
			System.out.println(dp[i][0]);
		}
		for(int j=1;j<m;j++) {
			dp[0][j]=dp[0][j-1]+sea[0][j];
			System.out.println(dp[0][j]);
		}
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				dp[i][j]=sea[i][j]+Math.max(dp[i-1][j],dp[i][j-1] );
				System.out.println(dp[i][j]);
			}
			
		}
		return dp[n-1][m-1];
		
		
	}

	public static void main(String[] args) {
		int[][] sea= {{2,1,1,1,1},{1,2,3,4,5},{1,3,6,10,15},{1,5,15,35,70}};
		System.out.println(maxFishInGrid(sea));
		
		System.out.println(maxFishInGridDP(sea));

	}

}
