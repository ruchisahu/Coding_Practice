import java.util.*;

public class TrieAPI2 {
	class TrieNode {
	    TrieNode[] children = new TrieNode[26];
	    boolean isWord = false;
	    List<String> startWith = new ArrayList<>();
	    public TrieNode() {}
	}
	class Trie {
	    TrieNode root;
	    public Trie (String[] words) {
	        root = new TrieNode();
	        // add into trie
	        for (String word : words) {
	            insert(word);
	        }
	    }
	    private void insert(String str) {
	        TrieNode cur = root;
	        for (char c : str.toCharArray()) {
	            if (cur.children[c - 'a'] == null) {
	                cur.children[c - 'a'] = new TrieNode();
	            }
	            cur.children[c - 'a'].startWith.add(str);
	            cur = cur.children[c - 'a'];
	        }
	        cur.isWord = true;
	    }
	    public List<String> findByPrefix(String str) {
	        TrieNode cur = root;
	        for (char c : str.toCharArray()) {
	            if (cur.children[c - 'a'] == null) {
	                return null;
	            }
	            cur = cur.children[c - 'a'];
	        }
	        return cur.startWith;
	    }
	}

}
