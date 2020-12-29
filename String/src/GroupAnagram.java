import java.util.*;
//O(aloga* blogb)
public class GroupAnagram {
	public class AnagramComparator implements Comparator<String> {
		private String sortChars(String s) {
			char[] charString=s.toCharArray();
			Arrays.sort(charString);
			return new String(charString);
		}

		@Override
		public int compare(String s1, String s2) {
			return sortChars(s1).compareTo(sortChars(s2));
			
		}
	}
	public static String stringArrayToString(String[] array) {
		StringBuilder sb = new StringBuilder();
		for (String v : array) {
			sb.append(v + ", ");
		}
		return sb.toString();
	}
	
	//sol2
	//O(NKlogK)
	 public static List<List<String>> groupAnagrams(String[] strs) {
	        if (strs.length == 0) return new ArrayList();
	        Map<String, List> ans = new HashMap<String, List>();
	        for (String s : strs) {
	            char[] ca = s.toCharArray();
	            Arrays.sort(ca);
	            String key = String.valueOf(ca);
	            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
	            ans.get(key).add(s);
	        }
	        return new ArrayList(ans.values());
	    }

	public static void main(String[] args) {
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		Arrays.sort(array);
		System.out.println(stringArrayToString(array));
		System.out.println("sol2:");
		List<List<String>> result=groupAnagrams(array);

	}

}
