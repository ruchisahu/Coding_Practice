
public class canPartition {
	 public static boolean canPartition(int[] nums) {
		 
		        // check edge case
		        if (nums == null || nums.length == 0) {
		            return true;
		        }
		        // preprocess
		        int volumn = 0;
		        for (int num : nums) {
		            volumn += num;
		        }
		        if (volumn % 2 != 0) {
		            return false;
		        }
		        volumn /= 2;
		        // dp def
		        boolean[] dp = new boolean[volumn + 1];
		        // dp init
		        dp[0] = true;
		        // dp transition
		        for (int i = 1; i <= nums.length; i++) {
		            for (int j = volumn; j >= nums[i-1]; j--) {
		                dp[j] = dp[j] || dp[j - nums[i-1]];
		            }
		        }
		        return dp[volumn];
		    }
		 
	 

	public static void main(String[] args) {
		int[] nums = {1,5,11,5};
		System.out.println(canPartition(nums));
		

	}

}
