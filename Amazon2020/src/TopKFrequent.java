import java.util.*;

/*
 * Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to
 *  least frequently mentioned.

The comparison of strings is case-insensitive.
Multiple occurances of a keyword in a review should be considred as a single mention.
If keywords are mentioned an equal number of times in reviews, sort alphabetically.

Example 1:

Input:
k = 2
keywords = ["anacell", "cetracular", "betacellular"]
reviews = [
  "Anacell provides the best services in the city",
  "betacellular has awesome services",
  "Best services provided by anacell, everyone should use anacell",
]

Output:
["anacell", "betacellular"]

Explanation:
"anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.

 */
public class TopKFrequent {
	
	//solution2
	public static List<String> getFrequent(int k,String[] keywords,String[] words){
	    Map<String,Integer> count= new HashMap<>();
	    List<String> keywordsList= Arrays.asList(keywords);
	    for(String word:words){
	      for(String s:word.split("\\s+")){
	        if(keywordsList.contains(s)){
	          count.put(s,count.getOrDefault(s,0)+1);
	        }
	      }    
	    }
	        
	    List<String> ls = new ArrayList<>(count.keySet());    
	    Collections.sort(ls, (a,b)-> (count.get(a)).equals(count.get(b))?a.compareTo(b):count.get(b)-count.get(a));    
	        
	    return ls.subList(0,k);  
	}
	//solution1-my solution working
	public static List<String> FindTop(int k, String[] keywords, String[] reviews)
	{
		List<String> word=new ArrayList<String>();
        HashMap<String, Integer> map=new HashMap<String, Integer>();
		
		for(String wor:keywords)
		{
			
				map.put(wor, 0);
		}
		
		for(String review: reviews)
		{
			String[] strs = review.split("\\W");
			Set<String> allword = new HashSet<String>();
			for(String s : strs) {
				
				allword.add(s.toLowerCase());
			}
			
			Iterator<String> i=allword.iterator();  
	        while(i.hasNext())  
	        {  
	        	String w=i.next();
	        
	        if(map.containsKey(w))
			{
				map.put(w, map.get(w)+1);
				// System.out.println(w+"   "+map.get(w)); 
			}
		 
			}
		}
		
		//priority queue
		Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b)->a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
		maxHeap.addAll(map.entrySet());
		while(!maxHeap.isEmpty() && k-- > 0) {
			word.add(maxHeap.poll().getKey());
		}
		//print result
		for(int i=0; i<word.size();i++)
		{
			System.out.println(word.get(i));
		}
		
		return word;
	}
	
	//sol
	public List<String> topKFrequent(String[] words, int k) {

        List<String> res = new ArrayList<>();

        if (words == null || words.length == 0) {

            return res;

        }

        Map<String, Integer> map = new HashMap<>();

        for (String w : words) {

            map.put(w, map.getOrDefault(w, 0) + 1);

        }

        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {

            @Override

            public int compare(String s1, String s2) {

                if (map.get(s1) == map.get(s2)) {

                    return s1.compareTo(s2);

                }

                return map.get(s2) - map.get(s1);

            }

        });

        pq.addAll(map.keySet());

        for (int i = 0; i < k; i++) {

            if (!pq.isEmpty()) {

                res.add(pq.poll());

            }

        }

        return res;

    }



	public static void main(String[] args) {
		
		int k = 2;
		String[] keywords = { "anacell", "cetracular", "betacellular" };
		
		
		String[] reviews = { "Anacell provides the best services in the city", "betacellular has awesome services",
				"Best services provided by anacell, everyone should use anacell", };
		
		//FindTop(k,keywords, reviews);
		
	//	getFrequent(k,keywords,reviews);
		
		/////////////////////////////
		
		String[] reviews1 = {"Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
		"The new Elmo dolls are super high quality",
		"Expect the Elsa dolls to be very popular this year, Elsa!",
		"Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
		"For parents of older kids, look into buying them a drone",
		"Warcraft is slowly rising in popularity ahead of the holiday season"};
		
		String[] keywords1 = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
		
      FindTop(k,keywords1, reviews1);
		
      
	}

}
