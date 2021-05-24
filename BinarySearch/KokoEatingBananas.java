//https://leetcode.com/discuss/general-discussion/786126/python-powerful-ultimate-binary-search-template-solved-many-problems
public class KokoEatingBananas {
	public static int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 0;
        for (int p: piles) {
        	hi=Math.max(hi, p);
        }
      //  
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (!possible(piles, H, mi))
                lo = mi + 1;
            else
                hi = mi;
        }

        return lo;
    }

    // Can Koko eat all bananas in H hours with eating speed K?
    public static boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p: piles)
            time += (p-1) / K + 1;
        	//time+=Math.ceil(p/K);
        return time <= H;
    }

	public static void main(String[] args) {
		int[] piles = {3,6,7,11};
		int h = 8;
		
		System.out.println(minEatingSpeed(piles,h));

	}

}
