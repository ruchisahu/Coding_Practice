


class TrieT {
	
	public class TrieNode2{
	    public boolean isWord;
	    public TrieNode2[] children;
	    public TrieNode2(){
	        children = new TrieNode2[26];
	        isWord = false;
	    } 
	}
    private TrieNode2 root;
    public TrieT() {
        root = new TrieNode2();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode2 current_node = root;
        
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current_node.children[index] == null) {
                current_node.children[index] = new TrieNode2();
            }
            current_node = current_node.children[index];
        }
        current_node.isWord = true;
    }
   
    public boolean search(String word) {
        TrieNode2 current_node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current_node.children[index] == null) return false;
            current_node = current_node.children[index];
        }
        return current_node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode2 current_node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (current_node.children[index] == null) return false;
            current_node = current_node.children[index];
        }
        return true;
    }

	public static void main(String[] args) {
		TrieT trie = new TrieT();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // returns true
		System.out.println(trie.search("app"));     // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // returns true

	}

}
