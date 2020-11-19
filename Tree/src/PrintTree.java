import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintTree {
	//Iteration
		public static List<Integer> TraversalIter(TreeNode root){
			List < Integer > result = new ArrayList < > ();
	        Stack < TreeNode > stack = new Stack < > ();
	        TreeNode curr = root;
	        while (curr != null || !stack.isEmpty()) {
	            while (curr != null) {
	                stack.push(curr);
	                curr = curr.left;
	            }
	            curr = stack.pop();
	            result.add(curr.val);
	            curr = curr.right;
	        }
	        for(int i=0;i<result.size();i++)
	        	System.out.println(result.get(i));
	        return result;
		}

}
