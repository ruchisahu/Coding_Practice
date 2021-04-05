import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//DOubt
//https://leetcode.com/discuss/interview-question/1014671/Google-Phone-Interview
public class beforeAfterlistOfWords {
	private static List<List<String>> solve(List<String> words, String target, int k) {
        // k is the number of words to be covered to the left and right
        int n = words.size();
        List<List<String>> sol = new ArrayList<>();
        Queue<String> list = new LinkedList<>();
        // maintain window of size 2*k+1
        // we're maintaining the possible list in queue so that we can simply append when the window is valid
        int sz = 2*k+1;
        for (int i=0;i<n;i++) {
            list.add(words.get(i));
            if (i-sz >= 0)list.poll(); // remove head
            if (i-sz >= -1) { // valid window of size sz
                // check if the mid is target
                int mid = i - (sz/2);
                if (words.get(mid).equals(target)) { // now we have k words to the left and k words to the right
                    sol.add(new ArrayList<>(list)); // make a copy
                }
            }
        }
        return sol;
    }
	  
	  public static List<List<String>> listOfWords(String[] wordLists, String word, int n){
		  if(wordLists == null || wordLists.length == 0)
		  return null;
		  List<List<String>> sol = new ArrayList<>();
		  int len = wordLists.length-1;
		  for (int i = 0; i < wordLists.length; i++) {
			  if(wordLists[i].equals(word)){
				  String[] t =(Arrays.copyOfRange(wordLists, Math.max(0, i-n), Math.min(len, i+n+1)));
				  List<String>mylist=Arrays.asList(t);
				  sol.add(mylist);
			  }
		  }
		  return sol;
		  }
			

	public static void main(String[] args) {
		String[] words= {"apple" , "bat" , "cat" , "fish" , "leetcode","leetcode", "snip" , "snap" ,"hat" ,"dog"};
		int k=3;
		String match="leetcode";
		listOfWords(words,match,k);
		//solve(words,match,k);

	}

}
