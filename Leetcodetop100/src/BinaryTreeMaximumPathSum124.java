//https://medium.com/algorithm-and-datastructure/binary-tree-maximum-path-sum-3e5a0353a55a
/*
 We can see that two conditions have arisen.
root+left+right
root+max(left, right)

 */
public class BinaryTreeMaximumPathSum124 {
	static int max= max=Integer.MIN_VALUE;
	 static int res=Integer.MIN_VALUE;
	    public static int maxPathSum(TreeNode root) {
	        solve(root);
	        return res;
	    }
	   static int solve(TreeNode root)
	    {
	        if(root==null)
	            return 0;
	        
	        int l=solve(root.left);
	        int r=solve(root.right);
	        
	        int temp=Math.max(Math.max(l,r)+root.val,root.val);
	        int ans=Math.max(temp,l+r+root.val);
	        
	        res=Math.max(ans,res);
	        return temp;
	        
	    }
	

	public static void main(String[] args) {
		TreeNode root = TreeSample.createbstTree();
		 System.out.println(maxPathSum(root));
		

	}

}
