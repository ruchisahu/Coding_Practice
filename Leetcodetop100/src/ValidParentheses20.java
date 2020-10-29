import java.util.Stack;

public class ValidParentheses20 {
	 public static boolean isValid(String s) {
		 int len=s.length();
		 Stack<Character> stack=new Stack<Character>();
		 for(int i=0;i<len;i++) {
			// char c=s.charAt(i);
			 if(s.charAt(i)=='(') stack.push('(');
	            if(s.charAt(i)=='{') stack.push('{');
	            if(s.charAt(i)=='[') stack.push('[');
	            if(s.charAt(i)==')')
	            {
	                if(stack.isEmpty()) return false;
	                if(stack.pop()!='(') return false;
	            }
	             if(s.charAt(i)=='}')
	            {
	                if(stack.isEmpty()) return false;
	                if(stack.pop()!='{') return false;
	            }
	             if(s.charAt(i)==']')
	            {
	                if(stack.isEmpty()) return false;
	                if(stack.pop()!='[') return false;
	            }
	                
	        }
	        return stack.isEmpty();
			 
		
	        
	    }

	public static void main(String[] args) {
		String s="()[]{}";
		System.out.println(isValid(s));

	}

}
