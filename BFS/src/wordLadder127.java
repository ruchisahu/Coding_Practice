import java.util.*;

public class wordLadder127 {
	 public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		  Queue<String> queue = new LinkedList<String>();
	        Set<String> words = new HashSet<>(wordList);
	        words.remove(beginWord);
	        queue.add(beginWord);
	        
	        int level = 0;
	        while(!queue.isEmpty()){
	        int size = queue.size();
	        level++;
	        for(int i=0;i<size;i++)
	        {
	            String currentword = queue.poll();
	            if(currentword.equals(endWord)) return level;
	            List<String> neighbors = neighbor(currentword);
	            
	            for(String neigh:neighbors)
	            {
	                if(words.contains(neigh))
	                {
	                    words.remove(neigh);
	                    queue.add(neigh);
	                }
	            }
	        }
	        }
	      return 0;  
	    }
	    
	    public static List<String> neighbor(String s)
	    {
	        char[] chars = s.toCharArray();
	        List<String> result = new ArrayList<>();
	        for(int i=0;i<chars.length;i++)
	        {
	            char temp=chars[i];
	            for(char c='a';c<='z';c++)
	            {
	                chars[i]=c;
	                String neighbor = new String(chars);
	                result.add(neighbor);
	            }
	            chars[i]=temp;
	        }
	        return result;
	    
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordList = {"hot","dot","dog","lot","log","cog"};
		System.out.println(ladderLength(beginWord,endWord, Arrays.asList(wordList)));

	}

}
