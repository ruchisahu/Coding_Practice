import java.util.ArrayList;
import java.util.*;



/*
 * given a String S of lowercase letters ,you need to find as many substring as you can which satisfy the following conditions
1)no overlap among substrings.
2)one letter can exist in one substring. for every letter C in a substring ,all occurrences of C must also be in the same substring.
3)you want to find as many substrings as possible
4)if there are two solutions with same number of substrings . return the one with smaller total length.

input S="bbeadcxede";
output=["bb","a","c","x"];

input S="baddacxb";
output=["dd","c","x"];
incorrect is["adda","c","x"] as total length of this is 6 where output has total length 4 .
 */
public class NoOverlapString {
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		String s = "baddacxb";
		int i = 0;
		
		Set<Character> seen=new HashSet<Character>();
		
		while (i < s.length()) {
		char charAt = s.charAt(i);
		int lastIndexOf = s.lastIndexOf(charAt + "");
		if (!seen.contains(charAt) && !anyCharacterBtw(s, charAt, i, lastIndexOf)) {
		l.add(s.substring(i, lastIndexOf + 1));
		i = lastIndexOf + 1;
		} else {
		i++;
		}
		seen.add(charAt);
		}
		l.stream().forEach(System.out::println);
		}

		private static boolean anyCharacterBtw(String s, char x, int i, int lastIndexOf) {
			while (i <= lastIndexOf) {
				if (s.charAt(i) != x) {
					return true;
				}
				i++;
			}
			return false;
		}
	
	}


