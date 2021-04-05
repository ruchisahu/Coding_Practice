//https://leetcode.com/problems/house-robber-ii/

//https://leetcode.com/discuss/interview-question/978112/Google-or-L4-or-Onsite-SWE-or-Standups


public class FindNumberOfPossibleStandups {
	public int findNumberOfPossibleStandups(int n) {
		Integer[][] memo = new Integer[(1 << n) - 1][n];
		return findNumberOfPossibleStandupsDpTopDown(memo, n, 1, 0);
	}

	private int findNumberOfPossibleStandupsDpTopDown(Integer[][] memo, int n, int bitmask, int curr) {
		if(Integer.bitCount(bitmask) == n) // Or compare it to ((1 << n) - 1)
			return 1;
		
		if(memo[bitmask][curr] != null)
			return memo[bitmask][curr];
		
		int ways = 0;
		
		for(int i = 0; i < n; i++) {			
			int prev = i - 1;
			if(prev < 0) prev += n;	
			int next = (i + 1) % n;
			
			if(next != curr && prev != curr && ((1 << i) & bitmask) == 0) {
				ways += findNumberOfPossibleStandupsDpTopDown(memo, n, (1 << i) | bitmask, i);
			}
		}
		
		memo[bitmask][curr] = ways;
		return memo[bitmask][curr];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
