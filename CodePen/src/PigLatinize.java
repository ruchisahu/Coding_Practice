import java.util.HashSet;
/*
 * 1) Take the first consonant (or cluster of consonants) of a word, move it to the end of the word, and add a suffix of "ay"
2) If a word begins with a vowel, just add "way" at the end
3) For the sake of readability, separate the Pig Latin-ized parts of the word with a dash `-`

Your challenge is to implement the method `pigLatinize` that takes a string phrase and translates it to Pig Latin. You're free to add additional classes, variables, and methods if you would like.

The input phrase could be as short as a single word, or as long as multiple sentences or paragraphs. Whitespace, capitalization, and punctuation should be honored and maintained in your final answer.

#### Examples

1) "pig" => "ig-pay"
2) "pig latin" => "ig-pay atin-lay"
3) "Pig Latin" => "ig-Pay atin-Lay"

 */
public class PigLatinize {
	 public static void main(String[] args) {
		    System.out.println(pigLatinize("pig")); // should print out "ig-pay"
		    System.out.println(pigLatinize("pig Latin"));
		  }

		  // Implement this method:
		  public static String pigLatinize(String phrase) {
		    HashSet<Character>set=new HashSet<>();
		    set.add('a');
		    set.add('e');
		    set.add('i');
		    boolean vowel=set.contains(phrase.charAt(0))?true:false;
		    if(vowel)return phrase+"way";
		    StringBuilder sb=new StringBuilder();
		   
		    String[] words=phrase.split(" ");
		    boolean CountPlus=words.length>1?true:false;
		    for(String word:words) {
		    	char[] phaseChar=word.toCharArray();
		    	char start=phaseChar[0];
		    	for(int i=1;i<phaseChar.length;i++) {
		    		sb.append(phaseChar[i]);
		    		
		    	}
		    	sb.append("-");
		    	sb.append(start+"ay");
		    	if(CountPlus)sb.append(" ");
		    }
		    
		    
		    
		    return sb.toString();
		  }
}