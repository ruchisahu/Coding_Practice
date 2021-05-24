import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//O(n)    
public class LongestContainedInterval {
	static int longestInterval(List<Integer> list) {
		Set<Integer> set=new HashSet<>(list);
		int maxIntervalSize=0;
		
		while(!set.isEmpty()) {
			int val=set.iterator().next();
			set.remove(val);
			
			int lowerBound=val-1;
			while(set.contains(lowerBound)) {
				set.remove(lowerBound);
				--lowerBound;
			}
			int upperBound=val+1;
			while(set.contains(upperBound)) {
				set.remove(lowerBound);
				++upperBound;
			}
			maxIntervalSize=Math.max(maxIntervalSize, upperBound-lowerBound-1);
		}
		return maxIntervalSize;}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(8,3,-2,-5,0,3,7,9,8,1,2,0,-1,5,8);
		System.out.println(longestInterval(list));

	}

}
