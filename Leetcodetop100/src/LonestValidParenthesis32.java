import java.util.Stack;

/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
Example 1:
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
 */
public class LonestValidParenthesis32 {
public static int longestValidParentheses(String s) {
	Stack<Integer> stack = new Stack<Integer>();
    int max=0;
    int left = -1;
    for(int j=0;j<s.length();j++){
        if(s.charAt(j)=='(') stack.push(j);            
        else {
            if (stack.isEmpty()) left=j;
            else{
                stack.pop();
                if(stack.isEmpty()) max=Math.max(max,j-left);
                else max=Math.max(max,j-stack.peek());
            }
        }
    }
    return max;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=")()())";
		String s1="()(()";
		//System.out.println(longestValidParentheses(s));
		
		System.out.println(longestValidParentheses(s1));

	}

}
