//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubArray {
	 public static int maxSubArray(int[] nums) {
	        if(nums.length<1) return 0;
	        int len=nums.length;
	        int[] dp=new int[len];
	        dp[0]=nums[0];
	        int ans=dp[0];
	        for(int i=1;i<len;i++)
	        {
	            dp[i]=Math.max(dp[i-1]+nums[i], nums[i]);
	             ans = Math.max(ans, dp[i]);
	             
	        }
	        
	        return ans;
	    }

	public static void main(String[] args) {
		int[] nums= {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
		

	}

}
