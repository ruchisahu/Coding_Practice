
public class ValidateBST {
	public static boolean checkBST(TreeNode root) {
		 return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public static boolean isValidBST(TreeNode root, long minVal, long maxVal)
    {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

	public static void main(String[] args) {
		TreeSample T=new TreeSample();
		TreeNode root=T.createbstTree();
		System.out.println(checkBST(root));
		TreeNode root1=T.createbstTree652();
		System.out.println(checkBST(root1));

	}

}
