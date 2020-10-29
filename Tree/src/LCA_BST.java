
public class LCA_BST {
	 public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 if (p.val > root.val && q.val > root.val)
	        {
	           
	            return lowestCommonAncestor(root.right, p, q);
	        } 
	        else if (p.val < root.val && q.val < root.val)
	        {
	            
	            return lowestCommonAncestor(root.left, p, q);
	        } 
	        else
	        {
	            
	            return root;
	        }
	 }
	 //sol2
	 public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

	        
	        int pVal = p.val;

	        
	        int qVal = q.val;

	        
	        TreeNode node = root;

	        
	        while (node != null) {

	            
	            int parentVal = node.val;

	            if (pVal > parentVal && qVal > parentVal) {
	                
	                node = node.right;
	            } else if (pVal < parentVal && qVal < parentVal) {
	               
	                node = node.left;
	            } else {
	                
	                return node;
	            }
	        }
	        return null;
	    }
	
//sol3
	 public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
	 if (root == null || root == p || root == q) return root;
	    TreeNode left = lowestCommonAncestor(root.left, p, q);
	    TreeNode right = lowestCommonAncestor(root.right, p, q);
	    if(left == null)
	        return right; 
	        if(right == null)
	            return left;
	        return root;
	    }
	public static void main(String[] args) {
		TreeNode head = TreeSample.createbstTree();
		TreeNode left=head.left;
		TreeNode right=head.right.left;
		
		 System.out.println(lowestCommonAncestor(head,left,right));

	}

}
