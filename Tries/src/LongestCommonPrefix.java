import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {
	class TrieNode{
        public TrieNode[] nextNode;
        public boolean isEnd;
        public char firstChar;
        public int size;
        
        public TrieNode(){
            this.nextNode = new TrieNode[26];
            this.isEnd = false;
            this.firstChar = ' ';
            this.size = 0;
        }
    }
    
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        else if(strs.length == 1)
            return strs[0];
        
        TrieNode root = new TrieNode();
        
        for(String s : strs){
            insert(s, root);
        }
        
        StringBuilder builder = new StringBuilder();
        
        TrieNode current = root;
        while(!current.isEnd && current.size == 1){
            builder.append(current.firstChar);
            current = current.nextNode[current.firstChar - 'a'];
        }
        
        return builder.toString();
    }
    
    private void insert(String s, TrieNode root){
        if(s != null){
            char[] letters = s.toCharArray();
            int i, N = letters.length;
            
            TrieNode current = root;
            for(i = 0; i < N; i++){
                if(current.nextNode[letters[i] - 'a'] == null){
                    current.nextNode[letters[i] - 'a'] = new TrieNode();
                    ++current.size;
                    if(current.size == 1){
                        current.firstChar = letters[i];
                    }
                }
                
                current = current.nextNode[letters[i] - 'a'];
            }
            
            current.isEnd = true;
        }
    }


	public static void main(String[] args) {
		LongestCommonPrefix lcp=new LongestCommonPrefix();
		String[] dict = { "code", "coder", "coding", "codable", "codec", "codecs", "coded",
                "codeless", "codependence", "codependency", "codependent",
                "codependents", "codes", "codesign", "codesigned", "codeveloped",
                "codeveloper", "codex", "codify", "codiscovered", "codrive"};
        
 
        System.out.println("Longest Common Prefix is " + lcp.longestCommonPrefix(dict));

	}

}
