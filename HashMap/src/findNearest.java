import java.util.*;

public class findNearest {
	public static int findNearest(List<String> list) {

	    Map<String, Integer> map = new HashMap<>();
	    int minDist = Integer.MAX_VALUE;
	    
	    for (int i = 0; i < list.size(); i++) {
	        if (map.containsKey(list.get(i))) {
	          minDist = Math.min(minDist, i - map.get(list.get(i)));
	          System.out.println(list.get(i)+"  " +minDist);
	        }

	        map.put(list.get(i), i);
	      }
	    return minDist == Integer.MAX_VALUE ? -1 : minDist;
	    }

	public static void main(String[] args) {
		List<String> list = Arrays.asList(
		        "Mark",
		        "Steve",
		        "Mason",
		        "Joan",
		        "Jordan",
		        "Greg",
		        "Mark",
		        "Garth",
		        "Joan",
		        "Daisy",
		        "Joan",
		        "Marcus"
		    );
		System.out.println(findNearest(list));

	}

}
