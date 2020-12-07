
public class SuccessorInOrderBST {
	public static TreeNode Successor(TreeNode root){
		return root;}

	public static void main(String[] args) {
		TreeSample T=new TreeSample();
		TreeNode root=T.createbstTree();
		System.out.println(Successor(root));

	}

}
