package test;
//https://leetcode.com/discuss/interview-question/437772/Google-or-Phone-or-Evaluate-Expression
import java.util.Stack;

//( + 5 6 ( * 2 3 4( + 3 4...) 7 8) 123 456)
public class evaluteEx {
	  public static int evaluateExpr(String input) {
	        Stack<Character> operatorStack = new Stack<>();
	        Stack<Integer> operandStack = new Stack<>();
	        boolean firstAfterOperator = true;
	        for (int i = 0; i < input.length(); i++) {
	            if (input.charAt(i) != ' ') {
	                System.out.println("operand stack: " + operandStack);
	                if (input.charAt(i) == '*' || input.charAt(i) == '+') { // found operator
	                    operatorStack.push(input.charAt(i));
	                    firstAfterOperator = true;
	                } else if (input.charAt(i) == ')') {
	                    operatorStack.pop();
	                    if (operandStack.size() < 2) break; // 
	                    int first = operandStack.pop();
	                    int second = operandStack.pop();
	                    if (operatorStack.peek() == '*') {
	                        operandStack.push(first * second);
	                    } else if (operatorStack.peek() == '+') {
	                        operandStack.push(first + second);
	                    }
	                } else if (input.charAt(i) != '(') { // found integer
	                    if (firstAfterOperator) {
	                        operandStack.push(Integer.parseInt("" + input.charAt(i)));
	                        firstAfterOperator = false;
	                    } else {
	                        int first = operandStack.pop();
	                        int second = Integer.parseInt(""+ input.charAt(i));
	                        if (operatorStack.peek() == '*') {
	                            operandStack.push(first * second);
	                        } else if (operatorStack.peek() == '+') {
	                            operandStack.push(first + second);
	                        }
	                    }
	                }
	            }
	        }
	        return operandStack.pop();
	    }
	public static void main(String[] args) {
        System.out.println("Hello World!");
        String input = "( + 5 6 ( * 2 3 4 ( + 3 4 ) 7 8 ) 123 456)";  //9440
        System.out.println(evaluateExpr(input));
    }

}
