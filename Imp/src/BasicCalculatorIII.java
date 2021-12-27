import java.util.Stack;

/*
Leetcode 772 Basic Calculator III

Implement a basic calculator to evaluate a simple expression string.
The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses ) and empty spaces . The integer division should truncate toward zero.
You may assume that the given expression is always valid. All intermediate results will be in the range of [-2147483648, 2147483647].

Some examples:
"1 + 1" = 2
" 6-4 / 2 " = 4
"2*(5+5*2)/3+(6/2+8)" = 21
"(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 */
public class BasicCalculatorIII {
    public static int calculator(String s){
        if(s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }

            if(c == '('){
                int left = 1;
                int j = i + 1;
                while(left > 0){
                    if(s.charAt(j) == '('){
                        left++;
                    }else if(s.charAt(j) == ')'){
                        left--;
                    }
                    j++;
                }
                num = calculator(s.substring(i + 1, j));
                i = j - 1;
            }

            if(i == s.length() - 1 || c != ' ' && !Character.isDigit(c)){
                if(c == '+'){
                    stack.push(num);
                }else if(c == '-') {
                    stack.push(-num);
                }else if(c == '*') {
                    stack.push(stack.pop() * num);
                }else if(c == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = c;
                num = 0;
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String args[]){
        //"2*(5+5*2)/3+(6/2+8)"
        String s = "2*(5+5*2)/3";
        System.out.println(calculator(s));
    }
}
