import java.util.*;
import java.util.List;

public class GroupingString {

    public static List<List<String>> groupAnagrams(String[] strs) {
    	Map<String,List<String>>map=new HashMap<>();
    	for(String s:strs) {
    		 char[] chars = s.toCharArray();
    	        Arrays.sort(chars);
    	        String sorted = new String(chars);
    	        if(!map.containsKey(sorted)) {
    	        	List<String>items = new ArrayList<>();
    	        	items.add(s);
    	        	map.put(sorted, items);
    	        }
    	        else {
    	        	map.get(sorted).add(s);
    	        }
    	}
    	List<List<String>> result=new ArrayList<List<String>>();
    	for(List<String>str:map.values()) {
    		result.add(str);
    	}
		return result;
        
    }

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		groupAnagrams(strs);

	}

}
