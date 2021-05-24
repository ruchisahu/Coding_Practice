import java.util.Stack;

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
public class minRemoveToMakeValid {
	public static String minRemoveToMakeValid(String s) {
        int len = s.length();
        boolean[] b = new boolean[s.length()];
        StringBuilder res = new StringBuilder("");
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<len;++i){
            if(s.charAt(i) == '(') st.push(i);
            else if(s.charAt(i) == ')'){
                if(!st.isEmpty()){
                   // match these pairs, all unmatched are false anyway
                    b[i] = true;
                    b[(int)st.pop()] = true; 
                }
            }else{
                b[i] = true; // any character other than ( and ) are true anyway
            }
        }               
        
        for(int i=0;i<len;++i){
            if(b[i]) res.append(s.charAt(i));
        }   
        
        return res.toString();
    }


	public static void main(String[] args) {
		String s = "lee(t(c)o)de)";
		minRemoveToMakeValid(s);

	}

}
