import java.util.*;

public class FrequencyCounter {
	 public static void main(String[] args) {
	        int distinct = 0, words = 0;
	      
	        HashMap<String, Integer> st = new HashMap<String, Integer>();
            String key="it was the best of times it was the worst of times\r\n" + 
            		"it was the age of wisdom it was the age of foolishness\r\n" + 
            		"it was the epoch of belief it was the epoch of incredulity\r\n" + 
            		"it was the season of light it was the season of darkness\r\n" + 
            		"it was the spring of hope it was the winter of despair";
	        // compute frequency counts
	       for(int i=0;i<key.length();i++)
	       {
	    	   
	            words++;
	            if (st.containsKey(key)) {
	                st.put(key, st.get(key) + 1);
	            }
	            else {
	                st.put(key, 1);
	                distinct++;
	            }
	        }

	        // find a key with the highest frequency count
	        String max = "";
	        st.put(max, 0);
	        for (String word : st.keySet()) {
	            if (st.get(word) > st.get(max))
	                max = word;
	        }

	      System.out.println(max + " " + st.get(max));
	        System.out.println("distinct = " + distinct);
	        System.out.println("words    = " + words);
	    }
	
}
