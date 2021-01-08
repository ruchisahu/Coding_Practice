import java.util.*;

public class GenerateParentheses22 {
	static List<String> list = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        backtrack(0, n, 0, new char[n*2], n, 0);
        return list;
    }
    public static void backtrack(int n, int leftBracketCount, int openBracketCount, char[] s, int goal, int index){
        if(n == goal){
            list.add(String.valueOf(s));
        }else if(index < s.length){
            if(leftBracketCount > 0) {
                s[index] = '(';
                backtrack(n,leftBracketCount - 1, openBracketCount + 1, s, goal, index+1);
            }
            if(openBracketCount > 0) {
                s[index] = ')';
                backtrack(n + 1, leftBracketCount, openBracketCount - 1, s, goal,index+1);
            }
        }
    }

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));

	}

}
