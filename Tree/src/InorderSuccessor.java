//https://www.youtube.com/watch?v=JdmAYw5h3G8
public class InorderSuccessor {
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //case1:when p has right node. return left most of right
		
		if (p.right != null) {
            TreeNode node = p.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        TreeNode node = root;
        TreeNode min = null;
        //case 2: there is no right node. return last left node from root to p.
        while (node != p && node != null) {
            if (node.val < p.val) {
                node = node.right;
            }
            else {
                min = node;
                node = node.left;
            }
        }
        return min;
    }

	public static void main(String[] args) {
		TreeSample T=new TreeSample();
		TreeNode root=T.createbstTree();
		TreeNode p=root.left;
		TreeNode min=inorderSuccessor(root, p);
		System.out.println(min.val);

	}

}
