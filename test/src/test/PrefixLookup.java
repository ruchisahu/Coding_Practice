package test;

import java.util.*;

public class PrefixLookup {
	class Node{
		String name;
		int val;
		public Node(String name,int val){
			this.name=name;
			this.val=val;
		}
	}
	public String prefix(Map<String, Integer> words, String str) {
		PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->b.val-a.val);
		for(Map.Entry<String, Integer>entry:words.entrySet()) {
			String s=entry.getKey();
			int v=entry.getValue();
			
			Node n=new Node(s, v);
			if(s.startsWith(str)) {
				pq.add(n);
			}
		}
		return pq.poll().name;
		
	}

	public static void main(String[] args) {
		  Map<String, Integer> words = new HashMap<>();
	        words.put("amazon", 10);
	        words.put("amock", 10);
	        words.put("amuck", 10);
	        words.put("am", 8);
	        words.put("as", 20);
	        words.put("ant", 4);
	        words.put("amazing", 7);
	        words.put("ambiguous", 12);
	        words.put("be", 10);
	        words.put("bee", 3);
	        words.put("bed", 22);
	        String str="a";
	        PrefixLookup p=new PrefixLookup();
	        System.out.println(p.prefix(words,str));

	}

}
