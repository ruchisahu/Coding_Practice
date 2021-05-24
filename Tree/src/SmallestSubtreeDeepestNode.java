
public class SmallestSubtreeDeepestNode {
	    int count;
	    int h;
	    TreeNode ans;
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
        ans=null;
        h=height(root)-1;
        count=0;
        calc(root,0);
        
        helper(root,0);
        return ans;
    }
	//height of a tree
	  public int height(TreeNode root){
	        if(root==null)   return 0;    
	        return 1+Math.max(height(root.left),height(root.right));
	 }
	  //calculate deepest node
	  public void calc(TreeNode root,int ch){ 
		  if(ch==h)   count++;
	  
	        if(root.left!=null)
	            calc(root.left,ch+1);
	        if(root.right!=null)
	            calc(root.right,ch+1);
	        
	    
	  }
	  public int helper(TreeNode root,int ch){
	        
	        if(root.left==null && root.right==null)
	        {
	            if(count==1 && h==ch)
	                ans=root;
	            
	            if(ch==h)     return 1;
	            else  return 0;
	        }
	        
	        
	        int l=0;
	        int r=0;
	        if(root.left!=null)          l=helper(root.left,ch+1);
	        if(root.right!=null)         r=helper(root.right,ch+1);
	        
	        if((l+r)==count && ans==null)           ans=root;
	        
	        return l+r;
	        
	        
	            
	  }

	public static void main(String[] args) {
		TreeSample T=new TreeSample();
		TreeNode root=T.deepestNode();
		SmallestSubtreeDeepestNode s=new SmallestSubtreeDeepestNode();
		System.out.println(s.subtreeWithAllDeepest(root).val);

	}

}
