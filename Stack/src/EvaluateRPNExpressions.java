import java.util.*;
//time O(n)    space:O(n)
public class EvaluateRPNExpressions {
	 public static Integer eval(String RPNExpression) {
		    String[] values = RPNExpression.split(",");
		    Stack<Integer> stack = new Stack<>();
		    Set<String> operations = new HashSet<>(Arrays.asList("-", "+", "/", "x"));
			for(String val:values) {
				if(operations.contains(val)) {
					 stack.push(calExpression(stack.pop(), stack.pop(), val));
				}
				else {
					stack.push(Integer.parseInt(val));
				}
			}
		    return stack.pop();
		    }
	 private static Integer calExpression(Integer num2, Integer num1, String oper) {
		 if (oper.equals("+")) {
		      return num1 + num2;
		    } else if (oper.equals("-")) {
		      return num1 - num2;
		    } else if (oper.equals("x")) {
		      return num1 * num2;
		    } else {
		      return num1 / num2;
		    }
	 }

	public static void main(String[] args) {
		String expression1="3,4,+,2,x,1,+";  //15
		
		 String expression2 = "1,1,+,-2,x";   //-4
		System.out.println(eval(expression1));
		System.out.println(eval(expression2));
	}

}
