import java.util.*;

public class CollectionRemoveItemFromList {
	 public static void main(String[] args) {
	        System.out.println("Demonstration of removeIf");
	        List<String> l1 = createList();
	        // remove all items which contains an "x"
	        l1.removeIf(s-> s.toLowerCase().contains("x"));
	        l1.forEach(s->System.out.println(s));
	    }

	    private static List<String>  createList() {
	        List<String> anotherList = new ArrayList<>();
	        anotherList.addAll(Arrays.asList("iPhone", "Ubuntu", "Android",
	        "Mac OS X"));
	        return anotherList;
	    }
	}

