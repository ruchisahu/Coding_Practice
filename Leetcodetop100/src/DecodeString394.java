import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
 Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 
Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"
 */
public class DecodeString394 {
	 public static String decodeString(String s) 
	 {
	        
		 Deque<Integer> num_deque = new ArrayDeque<>();
	        Deque<String> str_deque = new ArrayDeque<>();
	        
	        char[] array = s.toCharArray();
	        
	        for(int i=0;i<array.length;i++){
	            char c = array[i];
	            if(Character.isDigit(c)){
	                int num = c-'0';
	                int j = i+1;
	                while(j<array.length && Character.isDigit(array[j])){
	                    num = num*10 + (array[j]-'0');
	                    j++;
	                }
	                i = j-1;
	                num_deque.offerLast(num);
	                
	            }else if(c == '['){
	                str_deque.offerLast(c+"");
	            }else if(c == ']'){
	                String str = "";
	                while(str_deque.peekLast().equals("[") == false){
	                    str = str_deque.pollLast() + str;
	                }
	                str_deque.pollLast();
	                int num = num_deque.pollLast();
	                StringBuilder sb = new StringBuilder();
	                while(num--!=0){
	                    sb.append(str);
	                }
	                
	                str_deque.offerLast(sb.toString());
	            }else{
	                str_deque.offerLast(c+"");
	            }
	        }
	        
	        
	        StringBuilder strbuild = new StringBuilder();
	        while(str_deque.size()!=0){
	            strbuild.append(str_deque.pollFirst());
	        }
	        
	        return strbuild.toString();
	    }
	
	

	public static void main(String[] args) {
		String s="3[a2[c]]";
		System.out.println(decodeString(s));

	}

}
