import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKlogRecord 
{
	 public static List<String> topKFrequent(String[] nums, int k)
	    {
	        HashMap<String,Integer> map=new HashMap<String,Integer>();
	        
	         for (String n: nums) 
	         {
	          map.put(n, map.getOrDefault(n, 0) + 1);
	          }
	       PriorityQueue<String> pq =
	            new PriorityQueue<String>((n1, n2) -> map.get(n1) - map.get(n2));

	        for(String key:map.keySet())
	        {
	            pq.add(key);
	            if(pq.size() > k)
	                pq.poll();
	        }
	        
	        List<String> top_k = new LinkedList();
	    while (!pq.isEmpty())
	      top_k.add(pq.poll());
	    Collections.reverse(top_k);
	    
	    PriorityQueue<Map.Entry<String, Integer>> pq1 = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
       );
       
       for(Map.Entry<String, Integer> entry: map.entrySet())
       {
           pq1.add(entry);
           if(pq1.size()>k)
           {
               pq1.poll();
        
           }
           
           while(!pq1.isEmpty())
           {
        	   System.out.println("element="+pq1.poll());
        	  
           }
       }
	    return top_k;
	    }
	
	public static void main(String[] args) 
	{
		int k=1;
		String[] str= {"top1.com --{Date}","top1.com --{Date}","top1.com --{Date}","top2.com --{Date}","top5.com --{Date}","top3.com --{Date}","top2.com --{Date}"};
		 System.out.println(topKFrequent(str,k));

	}

}
