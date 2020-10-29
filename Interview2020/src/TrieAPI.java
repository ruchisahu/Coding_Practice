

	class Trie {
	    TrieNode root;
	    Trie() {
	        root = new TrieNode();
	    }
	    public void insert(String s) {
	        TrieNode cur = root;
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            if (cur.children[c - 'a'] == null) {
	                cur.children[c - 'a'] = new TrieNode();
	            }
	            cur = cur.children[c - 'a'];
	        }
	        cur.isWord = true;
	    }

	    public TrieNode search(String str) {
	        TrieNode cur = root;
	        for (char c : str.toCharArray()) {
	            int idx = c - 'a';
	            if (cur.children[idx] == null) {
	                return null;
	            } 
	            cur = cur.children[idx];           
	        }
	        return cur;
	    }

	    public boolean search1(String str) {
	    	TrieNode res = search(str);
	        return res != null && res.isWord;
	    }

	    public boolean startWith(String str) {
	    	TrieNode res = search(str);
	        return res != null;
	    }
	
	
	class TrieNode {
	    TrieNode[] children;
	    boolean isWord = false;
	    
	    public TrieNode() {
	    	children=new TrieNode[26];
	    }
	 
	    
	    
	    public boolean containsKey(char ch) {
	    	return children[ch -'a']!=null;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
	
