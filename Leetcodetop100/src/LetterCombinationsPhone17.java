import java.util.*;

public class LetterCombinationsPhone17 {
	Map<String, String> phone = new HashMap<String, String>() {{
	    put("2", "abc");
	    put("3", "def");
	    put("4", "ghi");
	    put("5", "jkl");
	    put("6", "mno");
	    put("7", "pqrs");
	    put("8", "tuv");
	    put("9", "wxyz");
	  }};
	 public static List<String> letterCombinations(String digits) {
		 List<String> result=new ArrayList<String>();
		 return result;
	        
	    }

	public static void main(String[] args) {
		String digits="23";
		letterCombinations(digits);

	}

}
