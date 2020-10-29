

	import java.util.*;
	import static java.lang.Integer.max;
	 

	
	 
	public class rightview 
	{
		// node class
	
	    // BFS iterative using queue for left view
	    static void left_view_iter( TreeNode root)
	    {
	        if(root == null){
	            return;
	        }
	 
	        // creating a Queue for storing node for level wise traversal
	        Deque<TreeNode> Q = new ArrayDeque<TreeNode>();
	        Q.add(root);
	        int level = 0, max_level = 0;
	 
	        while(!Q.isEmpty()){
	            // store the current size of the Q
	            int count = Q.size();
	            level += 1;
	            while(count > 0) {
	                // pop the first node from the queue
	            	 TreeNode NODE = Q.poll();;
	                Q.remove(0);
	                if(max_level < level) {
	                   // System.out.print(NODE.data + " ");
	                    max_level = level;
	                }
	 
	                // push the left child on queue
	                if (NODE.left != null) {
	                    Q.add(NODE.left);
	                }
	 
	                // push the right child on queue
	                if (NODE.right != null) {
	                    Q.add(NODE.right);
	                }
	                count--;
	            }
	        }
	    }
	     
	    public static void main(String arg[]) 
	    {
	    	 TreeNode head = new  TreeNode(1);
	        head.left = new  TreeNode(2);
	        head.right = new  TreeNode(3);
	        head.left.left = new  TreeNode(4);
	        head.left.right = new  TreeNode(5);
	        head.right.right = new  TreeNode(6);
	        head.left.left.right = new  TreeNode(7);
	        head.right.right.left = new  TreeNode(8);
	        head.left.left.right.left = new  TreeNode(9);
	        head.left.left.right.left.left = new  TreeNode(10);
	        head.right.right.left.right = new  TreeNode(11);
	        System.out.print("Left view of the binary tree is : ");
	        left_view_iter(head);
	    }
	}

