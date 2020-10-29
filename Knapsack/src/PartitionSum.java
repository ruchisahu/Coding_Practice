import java.util.Arrays;

//https://leetcode.com/problems/partition-equal-subset-sum/
// 1 5 1 1 5   return true
public class PartitionSum {
 static boolean findPartition(int arr[], int n) 
    { 
	 int sum = 0; 
     int i, j; 

     // Calculate sum of all elements 
     for (i = 0; i < n; i++) 
         sum += arr[i]; 

     if (sum%2 != 0) 
         return false; 

     boolean part[][]=new boolean[sum/2+1][n+1]; 

     // initialize top row as true 
     for (i = 0; i <= n; i++) 
         part[0][i] = true; 

     // initialize leftmost column, except part[0][0], as 0 
     for (i = 1; i <= sum/2; i++) 
         part[i][0] = false; 

     // Fill the partition table in bottom up manner 
     for (i = 1; i <= sum/2; i++) 
     { 
         for (j = 1; j <= n; j++) 
         { 
             part[i][j] = part[i][j-1]; 
             if (i >= arr[j-1]) 
                 part[i][j] = part[i][j] || 
                              part[i - arr[j-1]][j-1]; 
         } 
     } 
     return part[sum/2][n]; 
    }
 
 //sol2
 public boolean canPartition(int[] nums) {
	    int sum = 0;
	    
	    for (int num : nums) {
	        sum += num;
	    }
	    
	    if ((sum & 1) == 1) {
	        return false;
	    }
	    sum /= 2;
	    
	    int n = nums.length;
	    boolean[] dp = new boolean[sum+1];
	    Arrays.fill(dp, false);
	    dp[0] = true;
	    
	    for (int num : nums) {
	        for (int i = sum; i > 0; i--) {
	            if (i >= num) {
	                dp[i] = dp[i] || dp[i-num];
	            }
	        }
	    }
	    
	    return dp[sum];
	}
	public static void main (String[] args) 
    { 
        int arr[] = {3, 1, 1, 2, 2,1}; 
        int n = arr.length; 
        if (findPartition(arr, n) == true) 
            System.out.println("Can be divided into two "+"subsets of equal sum"); 
       
  
    } 
}
