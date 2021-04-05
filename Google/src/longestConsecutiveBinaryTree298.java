
public class longestConsecutiveBinaryTree298 {
	TreeNode root;
	 public int longestConsecutive(TreeNode root) {
		 if(root==null)return 0;
		 int res = 0;
	        dfs(root, root.val, 0, res);
	        return res;
		
		}

	private void dfs(TreeNode root, int val, int out, int res) {
		if(root==null)return;
		System.out.println("root.val: "+root.val+"val: "+val);
		if (root.val == val + 1) ++out;
        else out = 1;
        res = Math.max(res, out);
        System.out.println(res);
        dfs(root.left, root.val, out, res);
        dfs(root.right, root.val, out, res);
		
		
	}

	public static void main(String[] args) {
		longestConsecutiveBinaryTree298 tree = new longestConsecutiveBinaryTree298();
		  
        tree.root = new TreeNode(6);
        tree.root.right = new TreeNode(9);
        tree.root.right.left = new TreeNode(7);
        tree.root.right.right = new TreeNode(10);
        tree.root.right.right.right = new TreeNode(11);
  
        System.out.println(tree.longestConsecutive(tree.root));

	}

}
