import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonWord
{
	 public static String mostCommonWord(String paragraph, String[] banned) 
	 {
		  String[] words = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
	        Map<String, Integer> counter = new HashMap<>();
	        List<String> bannedList = Arrays.asList(banned);
	        
	        for (String str : words) {
	            if (bannedList.contains(str)) {
	                continue;
	            }
	            
	            if (!counter.containsKey(str)) {
	                counter.put(str, 0);
	            }
	            
	            counter.put(str, counter.get(str) + 1);
	        }
	        
	        int max = 0;
	        String result = "";
	            
	        for (String key : counter.keySet()) {
	            if (counter.get(key) > max) {
	                result = key;
	                max = counter.get(key);
	            }
	        }
	        
	        return result;
	    
	
	 }
	        
	public static void main(String[] args) 
	{
		String paragraph = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack’s and Jill’s favorite food.";
				String[] banned= {"and" , "he", "the", "to", "is", "Jack", "Jill"};
		System.out.println(mostCommonWord(paragraph,banned));

	}

}
