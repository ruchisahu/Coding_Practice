import java.util.Stack;

public class IsWellFormed {
	public static boolean isWellFormed(String s) {
		Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }
            else if(c==')'){
                if(stack.isEmpty())return false;
                if(stack.pop()!='(')return false;
            }
            else if(c=='}'){
                if(stack.isEmpty())return false;
                if(stack.pop()!='{')return false;
            }
             else if(c==']'){
                if(stack.isEmpty())return false;
                if(stack.pop()!='[')return false;
            }
        }
        return stack.isEmpty();
		
	}

	public static void main(String[] args) {
		String expression1 = "[()[]{()()}]";   //true
		String expression2 = "[()[]{()()";    //false
		isWellFormed(expression1);

	}

}
