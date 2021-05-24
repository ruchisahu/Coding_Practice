import java.util.*;

public class longestSubarraywithDistinctEnties {
	public static int longestSubarray(List<Integer> list) {
	    int start = 0;
	    int end = 0;
	    int n = list.size();
	    int maxSize = 0;
	    Map<Integer, Integer> map = new HashMap<>();
	    while (end < n) {
	      map.put(list.get(end), map.getOrDefault(list.get(end), 0) + 1);
	      
	        while (start < end && map.get(list.get(end)) > 1) {
	        map.put(list.get(start), map.getOrDefault(list.get(start), 0) - 1);
	        if (map.get(list.get(start)) == 0) {
	          map.remove(list.get(start));
	        }
	        start++;
	      }
	      end++;
	      maxSize = Math.max(maxSize, map.size());
	    }
	    System.out.println(start+"  "+end);
	    return maxSize;
	  }

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(7, 1, 8, 7, 9, 3, 4, 1, 2, 3, 4, 5, 3, 7, 2, 9);
		System.out.println(longestSubarray(list));
	}

}
