import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//772 https://wentao-shao.gitbook.io/leetcode/data-structure/basic-calculator/772.basic-calculator-iii
public class BasicCalculator {
	 public int calculate(String s) {
	        if (s == null || s.length() == 0) return 0;
	        Queue<Character> q = new LinkedList<>();
	        for (char c : s.toCharArray()) {
	            q.offer(c);
	        }
	        q.offer('+');
	        return cal(q);
	    }

	    private int cal(Queue<Character> q) {
	        char sign = '+';
	        Integer num = null;     // 1 - 0 - 1
	        Stack<Integer> stack = new Stack<>();
	        while (!q.isEmpty()) {
	            char c = q.poll();
	            if (c == ' ') continue;
	            if (Character.isDigit(c)) {
	                if (num != null) {
	                    num = 10 * num + c - '0';
	                } else {
	                    num = c - '0';
	                }
	            } else if (c == '(') {
	                num = cal(q);
	            } else {
	        // + - * / )
	                if (sign == '+' && num != null) {
	                    stack.push(num);
	                } else if (sign == '-') {
	                    if (c == '-' && num == null) { // -1--1
	                        c = '+'; // Negative + negative to positive
	                    } else if(num != null){
	                        stack.push(-num);
	                    }
	                } else if (sign == '*' && num != null) {
	                    stack.push(stack.pop() * num);
	                } else if (sign == '/' && num != null) {
	                    stack.push(stack.pop() / num);
	                }

	                if (c == ')') {
	                    break;
	                }
	                num = null;
	                sign = c;
	            }
	        }

	        int sum = 0;
	        while (!stack.isEmpty()) {
	            sum += stack.pop();
	        }
	        return sum;
	    }

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
