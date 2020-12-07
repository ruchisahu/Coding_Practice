
public class BinaryTreeBalance {
	public static boolean checkBalance(TreeNode root) {
		if(root==null)return true;
		if(root.left==null && root.right==null)return true;
		return Math.abs(height(root.left)-height(root.right))<=1 && checkBalance(root.left) && checkBalance(root.right);
		
	}
	public static int height(TreeNode root) {
		if(root==null)return 0;
		return 1+Math.max(height(root.left),height(root.right));
	}

	public static void main(String[] args) {
		TreeSample T=new TreeSample();
		TreeNode root=T.createbstTree();
		System.out.println(checkBalance(root));

	}

}
