import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
public class PairSongs {
	
	private static int solve(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for(int n : nums) {
			n = n%60;
			if(map.containsKey(60 - n == 60 ? 0 : 60 - n))
				res += map.get(60 - n == 60 ? 0 : 60 - n);
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		return res;
	}
	 public int numPairsDivisibleBy(int[] time) {
	       HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
	        int count = 0;
	        
	        for (int i = 0; i < time.length; i++) {
	            
	            int mod = time[i] % 60;
	            int rem = mod == 0? 0: 60 - mod;
	            count += map.getOrDefault(rem, 0);
	            
	            map.put(mod, 1 + map.getOrDefault(mod, 0));
	        }
	        
	        return count;
	    }
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
