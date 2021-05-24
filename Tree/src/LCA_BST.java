
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
	
//sol3 test
	
	    
	 static TreeNode lca;

	    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p,TreeNode q){
	          lca = null;	
	          dfs(root,  p,  q);
			return lca;
	  }

	  public static int dfs(TreeNode node, TreeNode p, TreeNode q){

		if(node == null)
		  return 0;

	    int count = 0;
	    
	    if(node.equals(p) || node.equals(q))
	        count++;
	    
	    count+=dfs(node.left, p,q);
	    count+=dfs(node.right, p,q);
	      
	      System.out.println(node.val);
	      if(count ==2 && lca == null)
	          lca = node;
	      
	      return count;
	      
	    }
	
	public static void main(String[] args) {
		TreeNode head = TreeSample.createbstTree();
		TreeNode left=head.right.right;
		TreeNode right=head.right.left;
		
	//	 System.out.println(lowestCommonAncestor(head,left,right));

		 
		 //test
		 TreeNode head1 = TreeSample.createbstTree();
		 System.out.println(lowestCommonAncestor2(head,left,right));
		 
	}

}
