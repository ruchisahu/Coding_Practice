import java.util.Stack;

public class RemoveDuplicate {
	 public static String removeDuplicates(String S) {
	        Stack<Character> stack = new Stack<>();
	        for(char s : S.toCharArray()){
	            if(!stack.isEmpty() && stack.peek() == s)
	                stack.pop();
	            else
	                stack.push(s);
	        }
	        StringBuilder sb = new StringBuilder();
	        for(char s : stack) sb.append(s);
	        return sb.toString();
	    }
	 public static String removeDuplicate(String s) {
		 StringBuilder sb = new StringBuilder();
		 char lastchar = '\0';
		 for (int i = 0; i < s.length(); i++) {
		   String str = sb.toString();
		   if (!str.equals("")
		       && (str.charAt(str.length() - 1) == s.charAt(i))) {
		     sb.deleteCharAt(str.length() - 1);
		   } else if (s.charAt(i) != lastchar)
		     sb.append(s.charAt(i));
		   lastchar = s.charAt(i);
		 }
		return sb.toString();
		}
	 
	 private static String remove(String str1) {
		    StringBuilder sb = new StringBuilder();
		    Stack<Character> stack = new Stack<Character>();
		    stack.push(str1.charAt(0));
		    int i = 1;
		    char lastDeleted = (Character) null;
		    while(!stack.isEmpty() && i < str1.length()){
		        if(str1.charAt(i) == stack.peek()) {
		              lastDeleted = stack.pop();
		        }else if(str1.charAt(i) == lastDeleted) {
		            
		        }else {
		              stack.push(str1.charAt(i));
		        }
		        i++;
		        if(stack.isEmpty() && i < str1.length()) {
		            stack.push(str1.charAt(i));
		            i++;
		        }
		    }
		    if(stack.isEmpty()) {
		        return "";
		    }else {
		        while(!stack.isEmpty()) {
		            sb.insert(0, stack.pop());
		        }
		    }
		    return sb.toString();
		}
	public static void main(String[] args) {
		String s = "aaaa";
		System.out.println(removeDuplicate(s));

	}

}
