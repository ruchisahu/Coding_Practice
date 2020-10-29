
public class SubtreeOfAnother {
	
	//best one
	  public boolean isSubtree2(TreeNode s, TreeNode t) {
	        if (s == null) return false;
	        if (isSame(s, t)) return true;
	        return isSubtree(s.left, t) || isSubtree(s.right, t);
	    }
	    
	    private boolean isSame(TreeNode s, TreeNode t) {
	        if (s == null && t == null) return true;
	        if (s == null || t == null) return false;
	        
	        if (s.val != t.val) return false;
	        
	        return isSame(s.left, t.left) && isSame(s.right, t.right);
	    }
	        ///
	 public boolean isSubtree(TreeNode s, TreeNode t)
	    {
	        String tree1=preorder(s, true);
	        String tree2=preorder(t, true);
	        return tree1.indexOf(tree2)>=0;
	    }
	    public String preorder(TreeNode t, boolean left)
	    {
	        if (t == null) {
	            if (left)
	                return "lnull";
	            else
	                return "rnull";
	        }
	        return "#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false);
	    }
	///sol2
	    public boolean isSubtree1(TreeNode s, TreeNode t) {
	        return traverse(s,t);
	    }
	    public boolean equals(TreeNode x,TreeNode y)
	    {
	        if(x==null && y==null)
	            return true;
	        if(x==null || y==null)
	            return false;
	        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
	    }
	    public boolean traverse(TreeNode s,TreeNode t)
	    {
	        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
	    }
	
//sol3
	    public boolean isSubtree3(TreeNode s, TreeNode t) {

	        return traverse3(s,t);

	    }

	    public boolean equals3(TreeNode x,TreeNode y)

	    {

	        if(x==null && y==null)

	            return true;

	        if(x==null || y==null)

	            return false;

	        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);

	    }

	    public boolean traverse3(TreeNode s,TreeNode t)

	    {

	        return  s!=null && ( equals3(s,t) || traverse(s.left,t) || traverse(s.right,t));

	    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
