import java.util.*;
//sol1 and 2 https://aaronice.gitbook.io/lintcode/data_structure/design-search-autocomplete-system
public class AutocompleteSystem {
	class TrieNode {
        Map<Character, TrieNode> children; 
        Map<String, Integer> counts;
        boolean isWord;

        public TrieNode () {
            children = new HashMap<>();
            counts = new HashMap<>();
            isWord = false;
        }
    }

    TrieNode root;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";

        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    private void add(String s, int count) {
        TrieNode curr = root;
        for (char c: s.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
            curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
        }
        curr.isWord = true;
    }

    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }
        prefix = prefix + c;

        TrieNode curr = root;

        for (char ch: prefix.toCharArray()) {
            if (!curr.children.containsKey(ch)) {
                return new ArrayList<String>();
            }
            curr = curr.children.get(ch);
        }

        Comparator<Map.Entry<String, Integer>> cmp = new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue();
            }
        };
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(cmp);
        int k = 3; 
        for (Map.Entry<String, Integer> entry: curr.counts.entrySet()) {
            pq.offer(entry);
            while (!pq.isEmpty() && pq.size() > k) {
                pq.poll();
            }
        }

        ArrayList<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }
        return res;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
