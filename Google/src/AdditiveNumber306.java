//https://leetcode.com/problems/additive-number/
//https://leetcode.com/problems/split-array-into-fibonacci-sequence/
//https://leetcode.com/discuss/interview-question/1038423/Find-if-magic-sequence-or-not-or-How-to-solve-this-or-12314374-greater-yes-12%2B31-43-31%2B43-74
//O(n^3)
public class AdditiveNumber306 {
	 public static boolean isAdditiveNumber(String num) {
	        int n = num.length();
	        if (n < 3) return false;
	        for (int i = 1; i <= n / 2; i++) {
	            if (i > 1 && num.charAt(0) == '0') break;
	            for (int j = i + 1; j < n; j++) {
	                if (j > i + 1 && num.charAt(i) == '0') break;
	                long first = Long.parseLong(num.substring(0, i));
	                long second = Long.parseLong(num.substring(i, j));
	                System.out.println(num.substring(0, i)+"    "+num.substring(i, j));
	                int k = j;
	                while (k < n) {
	                    long target = first + second;
	                    String s = String.valueOf(target);
	                    if (k + s.length() <= n && num.substring(k, k + s.length()).equals(s)) {
	                        k += s.length();
	                        first = second;
	                        second = target;
	                    }
	                    else break;
	                }
	                if (k == n) return true;
	            }
	        }
	        return false;
	    }
	

	public static void main(String[] args) {
		String num="199100199";
		System.out.println(isAdditiveNumber(num));

	}

}
