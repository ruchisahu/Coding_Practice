import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;


public class TrieST<Value> {
    private static final int R = 256;        // extended ASCII


    private Node root;      // root of trie
    private int n;          // number of keys in trie

    // R-way trie node
    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }
    public TrieST() {
    }

    // Returns the value associated with the given key.
 
    public Value get(String key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.val;
    }

   
     // Does this symbol table contain the given key?
   
    public boolean contains(String key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

   
     //Inserts the key-value pair into the symbol table, overwriting the old value
    
    public void put(String key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) delete(key);
        else root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            if (x.val == null) n++;
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }
     // Returns the number of key-value pairs in this symbol table.
    
    public int size() {
        return n;
    }

  
    //Is this symbol table empty?
  
    public boolean isEmpty() {
        return size() == 0;
    }

    
     // Returns all keys in the symbol table as an {@code Iterable}.
    
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    
     // Returns all of the keys in the set that start with {@code prefix}.
      
    public Iterable<String> keysWithPrefix(String prefix) {
    	 Deque<String> results = new  ArrayDeque<String>();
        Node x = get(root, prefix, 0);
        collect(x, new StringBuilder(prefix), results);
        return results;
    }

    private void collect(Node x, StringBuilder prefix, Queue<String> results) {
        if (x == null) return;
        if (x.val != null) results.add(prefix.toString());
        for (char c = 0; c < R; c++) {
            prefix.append(c);
            collect(x.next[c], prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
  
    // Returns all of the keys in the symbol table that match {@code pattern},
   
    public Iterable<String> keysThatMatch(String pattern) {
    	 Deque<String> results = new  ArrayDeque<String>();
        collect(root, new StringBuilder(), pattern, results);
        return results;
    }

    private void collect(Node x, StringBuilder prefix, String pattern, Queue<String> results) {
        if (x == null) return;
        int d = prefix.length();
        if (d == pattern.length() && x.val != null)
            results.add(prefix.toString());
        if (d == pattern.length())
            return;
        char c = pattern.charAt(d);
        if (c == '.') {
            for (char ch = 0; ch < R; ch++) {
                prefix.append(ch);
                collect(x.next[ch], prefix, pattern, results);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        else {
            prefix.append(c);
            collect(x.next[c], prefix, pattern, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    
     // Returns the string in the symbol table that is the longest prefix of {@code query},
   
    public String longestPrefixOf(String query) {
        if (query == null) throw new IllegalArgumentException("argument to longestPrefixOf() is null");
        int length = longestPrefixOf(root, query, 0, -1);
        if (length == -1) return null;
        else return query.substring(0, length);
    }

    private int longestPrefixOf(Node x, String query, int d, int length) {
        if (x == null) return length;
        if (x.val != null) length = d;
        if (d == query.length()) return length;
        char c = query.charAt(d);
        return longestPrefixOf(x.next[c], query, d+1, length);
    }


    public void delete(String key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) {
            if (x.val != null) n--;
            x.val = null;
        }
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }

        // remove subtrie rooted at x if it is completely empty
        if (x.val != null) return x;
        for (int c = 0; c < R; c++)
            if (x.next[c] != null)
                return x;
        return null;
    }

    public static void main(String[] args) {

        // build symbol table from standard input
        TrieST<Integer> st = new TrieST<Integer>();
      /*  for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
            
        }
        */
       //she sells sea shells by the sea shore
        st.put("she",0);
        st.put("sells",1);
        st.put("sea",2);
        st.put("shells",3);
        st.put("by",4);
        st.put("the",5);
        st.put("sea",6);
        st.put("sea",7);
        st.put("shore",8);
        // print results
       if (st.size() < 100) {
    	   System.out.println("keys(\"\"):");
            for (String key : st.keys()) {
            	System.out.println(key + " " + st.get(key));
            }
            System.out.println();
        }

       System.out.println("longestPrefixOf(\"shellsort\"):");
       System.out.println(st.longestPrefixOf("shellsort"));
       System.out.println();

        System.out.println("longestPrefixOf(\"quicksort\"):");
        System.out.println(st.longestPrefixOf("quicksort"));
        System.out.println();

        System.out.println("keysWithPrefix(\"shor\"):");
        for (String s : st.keysWithPrefix("shor"))
        	System.out.println(s);
        System.out.println();

        System.out.println("keysThatMatch(\".he.l.\"):");
        for (String s : st.keysThatMatch(".he.l."))
        	System.out.println(s);
            
    }
}