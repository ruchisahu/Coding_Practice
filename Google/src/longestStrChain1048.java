import java.util.Arrays;
//https://leetcode.com/problems/longest-string-chain/
public class longestStrChain1048 {
	 public int longestStrChain(String[] words) {
	        Arrays.sort(words, (a, b) -> b.length()-a.length());
	        int max = 0;
	        Trie t = new Trie();

	        for (String w : words) {
	            int cur = 1 + t.find(w, 0, false);
	            t.addWord(w, 0, cur);
	            max = Math.max(max, cur);
	        }

	        return max;
	    }

	    class Trie {
	        Trie[] next = new Trie[26];
	        boolean end = false;
	        int chain = 0;

	        void addWord(String w, int pos, int chain) {
	            if (pos == w.length()) {
	                end = true;
	                this.chain = chain;
	                return;
	            }
	            char c = w.charAt(pos);
	            if (next[c - 'a'] == null) next[c - 'a'] = new Trie();
	            next[c - 'a'].addWord(w, pos+1, chain);
	        }

	        int find(String w, int pos, boolean added) {
	            if (pos == w.length() && added) return chain;

	            int max = 0;
	            for (int i = 0; i < 26 && !added; i++) {
	                if (next[i] == null) continue;
	                max = Math.max(max, next[i].find(w, pos, true));
	            }

	            if (pos == w.length()) return max;

	            char c = w.charAt(pos);
	            if (next[c - 'a'] != null) max = Math.max(max, next[c - 'a'].find(w, pos+1, added));
	            return max;
	        }
	    }
	
	public static void main(String[] args) {
		String[] words = {"a","b","ba","bca","bda","bdca"};
		//longestStrChain(words);
		
		String[] words1 = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
		//longestStrChain(words1);
	}

}
