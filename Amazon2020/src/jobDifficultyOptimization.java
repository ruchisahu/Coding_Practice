import java.util.Arrays;
//https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/discuss/963963/Java-Top-down-and-bottom-up-DP-monotonic-stack-time-O(nd)-space-O(nd)-with-detailed-explanation
public class jobDifficultyOptimization {
	static int MAX = Integer.MAX_VALUE;
    static Integer[][] memo;
    static int[] maxDifficultyFromEnd;
    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d) return -1;
        if(n == d) {
            // scheduling each job/day
            int sum = 0;
            for(int jd: jobDifficulty) sum += jd;
            return sum;
        }
        memo = new Integer[n][d];
        // simple optimization
        fillMaxDifficultyFromEnd(jobDifficulty, n);
        // why d - 1? because we want to count last half as 1 part
        return difficulty(0, jobDifficulty, d - 1);
    }
    
    
    public static int difficulty(int index, int[] jobDifficulty, int d) {
        if(index == jobDifficulty.length && d != 0) return MAX;
        if(d == 0) {
            return maxDifficultyFromEnd[index];
        }
        if(memo[index][d] != null) return memo[index][d];
        
        int ans = MAX;
        int curr = jobDifficulty[index];
        
        for(int j = index + 1; j < jobDifficulty.length; j++) {
            int next = difficulty(j, jobDifficulty, d - 1);
            if(next == MAX) continue; // ans not possible
            // ans = min sum of first half + second half
            ans = Math.min(ans, curr + next);
            // calculating max of first half on the go.
            curr = Math.max(curr, jobDifficulty[j]);
        }
        memo[index][d] = ans;     
        return ans;
    }
    //sol2
    public static int minDifficulty2(int[] jobDifficulty, int d) {
        int len = jobDifficulty.length;
        if (len < d) return -1;
        if (len == d) {
            int sum = 0;
            for (int jd : jobDifficulty) {
                sum += jd;
            }
            return sum;
        }
        int[][] dp = new int[len][d+1];
        for (int[] sub : dp)
            Arrays.fill(sub, 10000);
        int max = 0;
        for (int j = 0; j < len; j++) {
            max = Math.max(max, jobDifficulty[j]);
            dp[j][1] = max;        
        }
        for (int i = 2; i <= d; i++) {    
            for (int j = len-1; j >= i-1; j--) {
                int min = 10000; max = 0;
                for (int k = j; k >= 1; k--) {
                    max = Math.max(max, jobDifficulty[k]);
                    min = Math.min(min, dp[k-1][i-1] + max);
                }
                dp[j][i] = min;
            }
        }
        return dp[len-1][d];
    }
    public static void fillMaxDifficultyFromEnd(int[] jobDifficulty, int n) {
        maxDifficultyFromEnd = new int[n];
        maxDifficultyFromEnd[n - 1] = jobDifficulty[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            maxDifficultyFromEnd[i] = Math.max(jobDifficulty[i], maxDifficultyFromEnd[i + 1]);
        }
    }


	public static void main(String[] args) {
		int[] jobDifficulty = {6,5,4,3,2,1};
		int d = 2;
		System.out.println(minDifficulty(jobDifficulty,d));  //7
		System.out.println(minDifficulty2(jobDifficulty,d));  //7
		
		int[] jobDifficulty1 = {7,1,7,1,7,1};
		int d1 = 3;
		System.out.println(minDifficulty(jobDifficulty1,d1));  //15
	}

}
