//https://leetcode.jp/problemdetail.php?id=776
//https://www.bbsmax.com/A/pRdBanl15n/
//Input: root = [4,2,6,1,3,5,7], V = 2
//Output: [[2,1],[4,3,6,null,null,5,7]]

public class splitBST776 {
	public static TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null)
            return new TreeNode[]{null, null};
        if (root.val == V) {
            TreeNode right = root.right;
            root.right = null;
            return new TreeNode[]{root, right};
        }
        else if (root.val > V) {
            TreeNode[] nodes = splitBST(root.left, V);
            TreeNode left = nodes[0];
            TreeNode right = nodes[1];
            root.left = right;
            return new TreeNode[]{left,root};
        } else {
            TreeNode[] nodes = splitBST(root.right, V);
            TreeNode left = nodes[0];
            TreeNode right = nodes[1];
            root.right=left;
            return new TreeNode[]{root, right};
        }
	}

	public static void main(String[] args) {
		TreeSample T=new TreeSample();
		TreeNode root=T.splitTree776();
		TreeNode[]splitTrees=splitBST(root,2);
		InOrder in=new InOrder();
		PrintTree.TraversalIter(splitTrees[0]);
		System.out.println("tree2:");
		PrintTree.TraversalIter(splitTrees[1]);

	}

}
