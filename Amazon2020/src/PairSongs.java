//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
public class PairSongs {
public static int numPairsDivisibleBy60(int[] time) {
        int count=0;
        int n=time.length;
        for(int i=0;i<n-1;i++) {
        	for(int j=i+1;j<n;j++) {
        		if((time[i]+time[j])%60==0)
        			count++;
        	}
        }
        return count;
    }
    
public int numPairsDivisibleBy601(int[] time) {
    int c[]  = new int[60], res = 0;
    for (int t : time) {
        res += c[(600 - t) % 60];
        c[t % 60] += 1;
    }
    return res;
}

	public static void main(String[] args) {
		int[] time= {30,20,150,100,40};
		System.out.println(numPairsDivisibleBy60(time));

	}

}
