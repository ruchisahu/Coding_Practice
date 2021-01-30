import java.util.Arrays;

//https://www.techiedelight.com/longest-increasing-subsequence-using-dynamic-programming/
//https://www.youtube.com/watch?v=66w10xKzbRM
public class LongestIncreasingSubsequence300 {
	  public static int lengthOfLIS(int[] nums) 
	    {
		  int[] dp=new int[nums.length];
		  dp[0]=1;
		  for (int i = 1; i < nums.length; i++)
	        {
	            
	            for (int j = 0; j < i; j++)
	            {
	            	if(nums[i]>nums[j] && dp[j]>dp[i]) {
	            		dp[i]=dp[j];
	            	}
	            }
	            dp[i]++;
	            }
			return Arrays.stream(dp).max().getAsInt();
		  
	    }
	  //sol2: https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
	 public static int lis(int arr[],int n) 
	    { 
	          int lis[] = new int[n]; 
	          int i,j,max = 0; 
	  
	          /* Initialize LIS values for all indexes */
	           for ( i = 0; i < n; i++ ) 
	              lis[i] = 1; 
	  
	           /* Compute optimized LIS values in  
	              bottom up manner */
	           for ( i = 1; i < n; i++ ) 
	              for ( j = 0; j < i; j++ )  
	                         if ( arr[i] > arr[j] &&  
	                                  lis[i] < lis[j] + 1) 
	                    lis[i] = lis[j] + 1; 
	  
	           /* Pick maximum of all LIS values */
	           for ( i = 0; i < n; i++ ) 
	              if ( max < lis[i] ) 
	                 max = lis[i]; 
	  
	            return max; 
	    } 

	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(nums));
		
		int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		System.out.println(lengthOfLIS(A));
	
	
	 int arr1[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
     int n1 = arr1.length; 
     System.out.println(lis(arr1,n1));
	}

}
