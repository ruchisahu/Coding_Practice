import java.util.Arrays;
import java.util.Comparator;

public class MinimumTaptoWaterGarden {
	 public static int minTaps1(int n, int[] ranges) {
	        
	        int[] maxRanges = new int[n+1];
	        
	        for (int i = 0; i <= n; i++)
	        {
	            int left = Math.max(0, i-ranges[i]), right = i+ranges[i];
	            
	            maxRanges[left] = Math.max(maxRanges[left], right - left);
	        }
	        
	        int start = 0, end = start + maxRanges[0], taps = 1;
	        
	        while (end < n)
	        {
	            int longPos = end;
	            
	            for (int j = start+1; j <= end; j++)
	                longPos = Math.max(longPos, j + maxRanges[j]);
	            
	            if (longPos == end)
	                return -1;
	            
	            start = end;
	            end = longPos;
	            taps++;
	        }
	        
	        return taps;
	    }
//sol2
	 public static int minTaps(int[] ranges) {
			int len = ranges.length;
			int[] dp = new int[len]; 
			Arrays.fill(dp, len + 1); 
			dp[0] = 0;

			for (int i = 0; i < len; i++) {
				int start = Math.max(i - ranges[i], 0);
				int end = Math.min(i + ranges[i], len - 1);
				for (int j = start; j <= end; j++) {
					dp[j] = Math.min(dp[j], dp[start] + 1);
				}
			}

			return dp[len - 1] == len + 1 ? -1 : dp[len - 1];
		}
	public static void main(String[] args) {
		;
		int[] ranges = {3,4,1,1,0,0};
		
		minTaps(ranges);

	}

}
