
public class LongestPalindromeSubstring5 {
	static int start;
	static int maxLen=0;  

	public static String longestPalindrome(String s) {
		// Boundary Check
		if (s == null || s.length()<= 1){
			return s;
		}      

		// Check if each character is a possible center of panlindromic substring
		for(int i=0; i<s.length(); i++){
			// Assume the palindrome has an odd length
			expandFromCenter(s, i, i);
			// Assume the palindrome has an even length
			expandFromCenter(s, i, i+1);
		}      
		return s.substring(start, start+maxLen);
	}

	public static  void expandFromCenter(String s, int left, int right){
		while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
			left --;
			right ++;
		}
		if ( maxLen < right - left -1){
			// Plus 1 because the left point has decremented before jumping out of the while loop, add 1 back
			start = left + 1;
			// update maxLen
			maxLen = (right-1) - (left +1) +1;
		}    
	}

	public static void main(String[] args) {
		String s="babad";
		System.out.println(longestPalindrome(s));

	}

}
