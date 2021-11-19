import java.util.Stack;

public class DecodeString394 {
	 public static String decodeString(String s) {
	        if (s.isEmpty()) return s;

	        Stack<String> st = new Stack<>();
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            if (Character.isDigit(c)) {
	                int digit = 0;
	                while (Character.isDigit(s.charAt(i))) digit = digit * 10 + (s.charAt(i++) - '0');
	                if (sb.length() != 0) st.push(sb.toString());
	                st.push(String.valueOf(digit));
	                sb = new StringBuilder();
	            } else if (c == ']') {
	                String str = sb.toString();
	                int repeat = Integer.parseInt(st.pop()) - 1;
	                while (repeat-- > 0) sb.append(str);
	                str = sb.toString();
	                while (!st.isEmpty() && !Character.isDigit(st.peek().charAt(0))) {
	                    str = st.pop().concat(str);
	                }
	                sb = new StringBuilder(str);
	            } else {
	                sb.append(c);
	            }
	        }
	        return sb.toString();
	    }

	public static void main(String[] args) {
		String  s = "3[a]2[bc]";
			System.out.println(decodeString(s));	//Output: "aaabcbc"
					
					String s1 = "3[a2[c]]";
							System.out.println(decodeString(s1));
					//Output: "accaccacc"
					

	}

}
