import java.util.*;
//http://tutorials.jenkov.com/java-collections/deque.html

public class DequeAPI {

	public static void main(String[] args) {
		Deque<String> deque = new ArrayDeque<>();

		deque.add("first element");
		deque.add("last element");

		String lastElement = deque.peekLast();
		System.out.println(lastElement);
		
		String firstElement = deque.peekFirst();
		System.out.println(firstElement);
		
		String firstElement1 = deque.peek();
		System.out.println(firstElement1);
		
		String firstElement2 = deque.getFirst();
		
		String lastElement1 = deque.getLast();
		
		deque.add("element 1");
		deque.addLast("element 1");
		
		deque.addFirst("element 1");
		deque.offer("element 1");
		
		deque.offerLast("element 1");
		
		deque.add("first element");
		deque.add("last element");
		
		String removedElement = deque.poll();
		

       String removedElement2 = deque.pop();
       boolean containsElement1 = deque.contains("first element");
       boolean containsElement2 = deque.contains("second element");
       
       int size = deque.size();
       
       Iterator<String> iterator = deque.iterator();
       while(iterator.hasNext())
    		   {
         String element = iterator.next();
       }
       
       
       for(String element : deque) {
    	    System.out.println(element);
    	}
       
       
       
       
		
		
		
	}

}
