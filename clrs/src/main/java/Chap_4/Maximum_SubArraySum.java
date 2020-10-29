package Chap_4;

public class Maximum_SubArraySum {
	static int max = Integer.MIN_VALUE;
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int[] aux = new int[nums.length + 1];
        Sort(preSum, 0, nums.length, aux);
        return max;
    }
    
    private static void Sort(int[] preSum, int lo, int hi, int[] aux) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        Sort(preSum, lo, mid, aux);
        Sort(preSum, mid + 1, hi, aux);
        max = Math.max(preSum[hi] - preSum[lo], max);
        for (int i = lo; i <= hi; i++) {
            aux[i] = preSum[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (j == hi + 1) { preSum[k] = aux[i++]; }
            else if (i == mid + 1) {preSum[k] = aux[j++]; }
            else if (aux[i] < aux[j]) { preSum[k] = aux[i++]; }
            else preSum[k] = aux[j++];
        }
    }
//sol2 DP
    public static int maxSubArrayDP(int[] nums) {
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
		int[] A= {-2,1,-3,4,-1,2,1,-5,4};
		int p=0;
		int r=A.length-1;
		
		System.out.println(maxSubArray(A));
		
		System.out.println(maxSubArrayDP(A));

	}

}
