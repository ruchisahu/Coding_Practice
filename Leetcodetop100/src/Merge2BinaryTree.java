
public class Merge2BinaryTree {
	 public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) 
	    {
		 if(t1==null)return t2;
		 if(t2==null)return t1;
		 TreeNode node=new TreeNode(t1.val + t2.val);
		 
		 node.left = mergeTrees(t1.left, t2.left);
	        node.right = mergeTrees(t1.right, t2.right);
	        System.out.println(node.val);
	        return node;
	    
	    }
	 
	 public static TreeNode mergeTrees1(TreeNode t1, TreeNode t2) 
	    {
		 if(t1==null)return t2;
		 if(t2==null)return t1;
		  t1=new TreeNode(t1.val + t2.val);
		 
		 t1.left = mergeTrees(t1.left, t2.left);
	        t1.right = mergeTrees(t1.right, t2.right);
	        System.out.println(t1.val);
	        return t1;
	    
	    }

	public static void main(String[] args) {
		TreeNode head = TreeSample.createbstTree();
		System.out.println(mergeTrees(head, head)); 
		System.out.println(mergeTrees1(head, head)); 

	}

}
