import java.util.Stack;
//https://www.youtube.com/watch?v=vq-nUF0G4fI
public class InfixToPostfix {	
	 public static String infixToPostfix(String str) {
	        Stack<Character> st = new Stack<>();
	        StringBuilder sb = new StringBuilder();

	        // "23+5*10-20/5" => "23510*+205/-"
	        // "2+3*4-5*6"
	        for (int i = 0; i < str.length(); i++) {
	            char c = str.charAt(i);
	            if (Character.isDigit(c)) {    //case 1 digit
	                sb.append(c);
	            } else if(c == '('){          //case 2 open bracket
	                st.push(c);
	            }else if(c == ')'){           //case3 close bracket pop everything till find open bracket
	                while(!st.isEmpty() && st.peek() != '('){
	                    sb.append(st.pop());
	                }
	                st.pop();
	            }else{
	                
	                while(!st.isEmpty() && st.peek() != '(' && isLower(c,st.peek())) {
	                    sb.append(st.pop());
	                }
	                st.push(c);
	            }
	        }

	        while(!st.isEmpty()){
	            sb.append(st.pop());
	        }

	        return sb.toString();
	    }

	    public static boolean isLower(char op1,char op2){
	        int num1 = getNum(op1);
	        int num2 = getNum(op2);

	        if(num1 <= num2) return true;
	        return false;

	    }

	    public static int getNum(char op){
	        int num = -1;
	        switch(op){
	            case '+': return 1;
	            case '-': return 1;
	            case '*': return 2;
	            case '/': return 2;
	        }
	        return num;
	    }

	    public static void main(String args[]){
	        // 234*+56*- "2+3*4-5*6"
	        //"((1+2)*3-4)*5" => 12+3*4-5*
	        String res = "((1+2)*3-4)*5";
	        System.out.println(infixToPostfix(res));
	    }

	}