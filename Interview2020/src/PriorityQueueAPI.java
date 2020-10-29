import java.util.*;

public class PriorityQueueAPI
{
	 public static void main(String[] args)
	 {
	      PriorityQueue<String> pq = new PriorityQueue<>();
	      
	      pq.add("Mercury");
	      pq.add("Venus");
	      pq.add("Earth");
	      pq.add("Mars");
	      pq.add("Jupiter");
	      pq.add("Saturn");
	      // Get the most priority element based upon
	      // natural alphabetic ordering in string
	      
	      
	      System.out.println("Priority element "+pq.peek());
	      // Queue elements
	      show(pq);
	      // Remove top of the queue element
	      pq.poll();
	      show(pq);
	      // Retrieves element from the head of the queue
	      pq.remove("Earth");
	      show(pq);
	      
	      String result = pq.contains("Earth")?
	         "Found Earth":"Earth Missing!";
	      System.out.println(result);
	      
	      Object[] arr = pq.toArray();
	      
	      Arrays.sort(arr);
	      System.out.println("");
	      for (int i = 0; i<arr.length; i++)
	         System.out.print(arr[i].toString()+"::");
	   }
	   public static void show(PriorityQueue<String> pq){
	      Iterator<String> itr = pq.iterator();
	      while (itr.hasNext())
	         System.out.print(itr.next()+"::");
	         System.out.println("");
	   }
	

}
