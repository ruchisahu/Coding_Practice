//https://leetcode.com/problems/edit-distance/
//https://www.youtube.com/watch?v=We3YDTzNXEk
public class EditDistance {
	  
    public static int minDistance(String word1, String word2) {
    	int n=word1.length();
    	int m=word2.length();
    	int[][]dp=new int[n+1][m+1];
    	for(int i=0;i<n;i++)
    		dp[i][0]=i;
    	
    	for(int j=0;j<=m;j++)
    		dp[0][j]=j;
    	
    	for(int i=1;i<=n;i++) {
    		for(int j=1;j<=m;j++) {
    			if(word1.charAt(i-1)==word2.charAt(j-1)) 
    			{
    				dp[i][j]=dp[i-1][j-1];
    			}
    			else 
    			{
    				dp[i][j]= 1+min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j]);
    			}
    			
    		}
    	}
    		
    	
		return dp[n][m];
    	
    }
        
    

	private static int min(int i, int j, int k) {
		int l=Math.min(i, j);
		int min=Math.min(l,k);
		// TODO Auto-generated method stub
		return min;
	}



	public static void main(String[] args) {
		String word3 = "horse";
		String word4 = "ros";
		System.out.println(minDistance(word3,word4));  //3
		
		String word1 = "intention";
		String word2 = "execution";
		System.out.println(minDistance(word1,word2));   //5

	}

}
