
public class mergeTrees {
	 public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		 if (t1 == null)
	            return t2;
	        if (t2 == null)
	            return t1;
	        t1.val += t2.val;
	        mergeTrees(t1.left, t2.left);
	        mergeTrees(t1.right, t2.right);
	        return t1;
	            
	 }

	public static void main(String[] args) {
		TreeSample T=new TreeSample();
		TreeNode root1=T.createbstTree();
		TreeNode root2=T.createbstTree652();
		
		System.out.println("root2 Before");
		InOrder in=new InOrder();
		in.Traversal(root1);
		System.out.println("root2 Before");
		
		in.Traversal(root2);
		
		mergeTrees(root1,root2);
		System.out.println("....after.........");
		
		in.Traversal(root1);
		

	}

}
