import java.util.*;

public class CollectionCustom {

	 public static void main(String[] args) {
	        List<Integer> list = Arrays.asList(5,4,3,7,2,1);

	        // custom comparator
	        Collections.sort(list, (o1, o2) -> (o1>o2 ? -1 : (o1==o2 ? 0 : 1)));
	        // alternative can could reuse the integer comparator
	        // Collections.sort(list, Integer::);
	        list.forEach(System.out::println);
	    }

	}
