//https://leetcode.com/problems/split-two-strings-to-make-palindrome/
//1616
public class checkPalindromeFormation {
	public static boolean checkPalindromeFormation(String a, String b) {
        int len=a.length(),l=0;
        boolean f1=true,f2=true;
        while(l<len/2) {
            if(f1) f1=a.charAt(l)==b.charAt(len-1-l);
            if(f2) f2=b.charAt(l)==a.charAt(len-1-l);
            if(f1||f2) l++;
            else break;
        }
        return isPalindrome(a,l)||isPalindrome(b,l);
    }
    
    static boolean isPalindrome(String s,int idx) {
        int len=s.length();
        for(int i=idx;i<len/2;i++) {
            if(s.charAt(i)!=s.charAt(len-1-i)) return false;
        }
        return true;
    }
	public static void main(String[] args) {
		String a = "ulacfd";
		String b = "jizalu";
		System.out.print(checkPalindromeFormation(a,b));

	}

}
