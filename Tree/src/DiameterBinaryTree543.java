import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Complexity Analysis

Time Complexity: O(N)O(N). We visit every node once.

Space Complexity: O(N)O(N), the size of our implicit call stack during our depth-first search.
 */
public class DiameterBinaryTree543 {
	
	//counting nodes
public static int diameterOfBinaryTree(TreeNode root) 
{
	if(root==null)return 0;
	int d=depth(root.left)+depth(root.right);

	return d+1;
        
    }

	private static int depth(TreeNode root) {
	
		if(root==null) return 0;
        if(root.left==null && root.right==null)
            return 1;
        
        return Math.max(depth(root.left), depth(root.right)) +1;
}
	
	//counting edges
	 static int ans;
	    public static int diameterOfBinaryTree1(TreeNode root) {
	        ans = 1;
	        depth1(root);
	        return ans - 1;
	    }
	    public static int depth1(TreeNode node) {
	        if (node == null) return 0;
	        int L = depth1(node.left);
	        int R = depth1(node.right);
	        ans = Math.max(ans, L+R+1);
	        return Math.max(L, R) + 1;
	}
//sol2
	    public static int diameterOfBinaryTree11(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        
	        int max = 0;
	        
	        Stack<TreeNode> stack = new Stack<>();
	        stack.push(root);
	        
	        while (!stack.isEmpty()) {
	            TreeNode current = stack.pop();
	            int di = calcDiameter(current) - 1;
	            
	            if (max < di) {
	                max = di;
	            }
	            
	            if (current.left != null) {
	                stack.push(current.left);
	            }
	            
	            if (current.right != null) {
	                stack.push(current.right);
	            }            
	        }
	        
	        return max;
	    }
	    
	    private static int calcDiameter(TreeNode root) {
	        return 1 + calcHeight(root.left) + calcHeight(root.right);
	    }
	    
	    private static int calcHeight(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        
	        int height = 0;
	        Queue<TreeNode> queue = new LinkedList<>();
	        
	        queue.add(root);
	        
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            ++height;
	            
	            while (size > 0) {
	                TreeNode current = queue.poll();
	                                
	                if (current.left != null) {
	                    queue.add(current.left);
	                }
	                
	                if (current.right != null) {
	                    queue.add(current.right);
	                }
	                
	                --size;
	            }
	            
	        }
	        
	        return height;
	    }
	
	public static void main(String[] args) {
		TreeNode head = TreeSample.createbstTree();
		System.out.println("counting nodes1="+diameterOfBinaryTree(head));
		System.out.println("counting edges1="+diameterOfBinaryTree1(head));
		System.out.println("counting edges2="+diameterOfBinaryTree11(head));

	}

}
