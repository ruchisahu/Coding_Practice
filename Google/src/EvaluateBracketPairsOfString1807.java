import java.util.*;

//https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
public class EvaluateBracketPairsOfString1807 {
	 public String evaluate(String s, List<List<String>> knowledge) {
			Map<String, String> map = new HashMap<>();
			for(List<String> k: knowledge) 
				map.put(k.get(0), k.get(1));
			StringBuffer result = new StringBuffer(), key = new StringBuffer();
			boolean isKey =false;
			for(int i=0;i<s.length();i++)
				if(s.charAt(i) == ')' && isKey==true) {
					isKey = false;
					if(map.containsKey(key.toString())) result.append(map.get(key.toString()));
					else result.append("?");
					key.setLength(0);
				} else if(isKey) key.append(s.charAt(i));
				else if(isKey == false && s.charAt(i) == '(')  isKey = true;
				else result.append(s.charAt(i));
			return result.toString();
		}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
