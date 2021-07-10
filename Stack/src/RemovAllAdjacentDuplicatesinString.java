import java.util.Stack;

public class RemovAllAdjacentDuplicatesinString {
    public static String removeAllAdjacentDuplicates(String S){
        if(S == null || S.length() == 0) return S;

        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();

        for(int i = 0; i < chars.length; i++){
            if(stack.isEmpty() || chars[i] != stack.peek()){
                stack.push(chars[i]);
            }else{
                stack.pop();

                while(i + 1 < chars.length && chars[i] == chars[i+1]){
                    i++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String args[]){
        String res = removeAllAdjacentDuplicates("aabbbac");
        System.out.println(res);
    }
}
