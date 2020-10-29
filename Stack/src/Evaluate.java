//https://algs4.cs.princeton.edu/13stacks/Evaluate.java.html
import java.util.Stack;
import java.util.TreeMap;

public class Evaluate {
	public static void main(String[] args)
	{
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		String[] str= {"(", "1", "(", "(", "2", "3", "+", ")", "(", "4", "5", "*", ")", "*", ")", "+",")" , };
		int i=0;
		while (i<str.length)
		{
			String s = str[i];
			if		(s.equals("("))			   	   ;
			else if	(s.equals("+"))		ops.push(s);
			else if	(s.equals("*"))		ops.push(s);
			else if	(s.equals(")"))
			{
				String op = ops.pop();
				if		(op.equals("+")) vals.push(vals.pop() + vals.pop());
				else if (op.equals("*")) vals.push(vals.pop() * vals.pop());
			}
			else vals.push(Double.parseDouble(s));
			i++;
		}
		System.out.println(vals.pop());
	}
}
    