import java.util.*;

//https://leetcode.com/problems/sort-characters-by-frequency
public class SortCharactersByFrequency451 {
	 public static String frequencySort(String s) {
		 HashMap<Character,Integer>map=new HashMap<Character,Integer>();
		 for(int i=0;i<s.length();i++) {
			 char c=s.charAt(i);
			 map.put(c, map.getOrDefault(c, 0)+1);
			 
		 }
		 PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
	        pq.addAll(map.entrySet());
	        StringBuilder sb = new StringBuilder();
	        while(!pq.isEmpty()) {
	        	Map.Entry e=pq.poll();
	        	for(int i=0;i<(int)e.getValue();i++) {
	        		sb.append(e.getKey());
	        	}
	        }
		return sb.toString();
	        
	    }
//sol2
	 public String frequencySort1(String s) {
	        //counts[i][0] is the actual char, counts[i][1] is frequency
	        int[][] counts = new int[256][2];
	        for(int i=0; i<s.length(); i++)
	        {
	            counts[s.charAt(i)][0] = s.charAt(i);
	            counts[s.charAt(i)][1]++;
	        }
	        
	        Arrays.sort(counts, (a, b)->(b[1]-a[1]));
	        
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i<counts.length; i++)
	        {
	            while(counts[i][1]>0)
	            {
	                sb.append((char)counts[i][0]);
	                counts[i][1]--;
	            }
	        }
	        return sb.toString();
	    }
	 
	 //sol3
	 public String frequencySort2(String s) {
	        Map<Character, Integer> map = new HashMap<>();
	        for (char c : s.toCharArray()) 
	            map.put(c, map.getOrDefault(c, 0) + 1);
							
	        List<Character> [] bucket = new List[s.length() + 1];
	        for (char key : map.keySet()) {
	            int frequency = map.get(key);
	            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
	            bucket[frequency].add(key);
	        }
					
	        StringBuilder sb = new StringBuilder();
	        for (int pos = bucket.length - 1; pos >= 0; pos--)
	            if (bucket[pos] != null)
	                for (char c : bucket[pos])
	                    for (int i = 0; i < pos; i++)
	                        sb.append(c);

	        return sb.toString();
	    }
	
	public static void main(String[] args) {
		String s="tree";
		System.out.println(frequencySort(s));

	}

}
