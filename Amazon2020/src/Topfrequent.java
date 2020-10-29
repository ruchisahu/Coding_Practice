import java.util.*;
import java.util.stream.Collectors;

public class Topfrequent {
	public static int[] topKFrequent(int[] nums, int k) {
		  HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	        
	         for (int n: nums) 
	         {
	          map.put(n, map.getOrDefault(n, 0) + 1);
	          }
	         
	         //magic
	         System.out.println(map.entrySet().stream()
	                 .sorted(Map.Entry.comparingByValue())
	                 .map(Map.Entry::getKey)
	                 .collect(Collectors.toList()));
	       
	           
	     
	         
	         /////
	         PriorityQueue<Integer> pq =
	                 new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));

	        for(int key:map.keySet())
	        {
	            pq.add(key);
	           // System.out.print(key);
	            if(pq.size() > k)
	            {
	                System.out.print(pq.peek());
	                pq.poll();
	                
	            }
	        }
	        int[] top_k = new int[k];
	        int i=0;
	    for(int i1 = k - 1; i1 >= 0; --i1) 
	    {
	      top_k[i1]= pq.poll();
	      
	    }
	    
	   
	    return top_k;
	    }
	

	public static void main(String[] args) {
		int[] nums = {6,7,2,2,2,2,3,5,5,5,5};
				int k = 2;
				System.out.println(topKFrequent(nums, k));

	}

}
