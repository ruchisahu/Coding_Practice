import java.util.Collections;
import java.util.*;

//https://leetcode.com/problems/most-common-word/discuss/411380
public class CompareHashMap {
	 public String mostCommonWord(String p, String[] banned) {
	        Set<String> ban = new HashSet<>(Arrays.asList(banned));
	        Map<String, Integer> count = new HashMap<>();
	        String[] words = p.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
	        for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
	        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
	    }
}
